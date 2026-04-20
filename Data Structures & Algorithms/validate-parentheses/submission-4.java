class Solution {
    public boolean isValid(String s) {
        if (s.length() % 2 == 1) {
            return false;
        }
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '{' ||
                s.charAt(i) == '(' ||
                s.charAt(i) == '[') {
                    stack.push(s.charAt(i));
            } else if (!stack.isEmpty() && (s.charAt(i) == '}' ||
                s.charAt(i) == ')' ||
                s.charAt(i) == ']')) {
                    String str = String.valueOf(stack.pop()) + s.substring(i, i+1);
                    if (!str.equals("()") &&
                        !str.equals("{}") &&
                        !str.equals("[]")) {
                            return false;
                        }
                } else {
                    return false;
                }
        }
        if (!stack.isEmpty()) {
            return false;
        }
        return true;
    }
}
