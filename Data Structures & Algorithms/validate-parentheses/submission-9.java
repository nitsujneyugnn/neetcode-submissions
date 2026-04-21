class Solution {
    // Most recently opened bracket should be closed first
    // Can use Stack to hold open brackets
    // every time we encounter a right close bracket, we compare to the one on the stack
    // once we reach the end, return true
    // edge cases:
    //  no open brackets before close - should return false
    //  only open brackets - should return false (stack will be filled)
    //  empty case - return true
    public boolean isValid(String s) {
       Stack<Character> open = new Stack<>();
       for (int i = 0; i < s.length(); i++) {
        char curr = s.charAt(i);
        if (curr == '{' || curr == '[' || curr == '(') {
            open.push(curr);
        } else if (curr == '}' || curr == ']' || curr == ')') {
            if (!open.isEmpty()) {
                char left = open.peek();
                if (curr == '}' && left == '{' ||
                    curr == ')' && left == '(' ||
                    curr == ']' && left == '[') {
                        open.pop();
                    } else {
                        return false;
                    }
            } else {
                return false;
            }
        } else {
            return false;
        }
       }
       return open.isEmpty();
    }
}
