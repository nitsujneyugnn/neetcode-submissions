class Solution {
    public List<String> generateParenthesis(int n) {
        String str = "";
        List<String> result = new ArrayList<>();
        generateParenthesis(n, result, str, 0, 0);
        return result;
    }

    private void generateParenthesis(int n, List<String> result,
                                    String str, int open, int close) {
        if (str.length() == n * 2) {
            result.add(str);
        } 
        if (open < n) {
            generateParenthesis(n, result, str + "(", open + 1, close);
        }
        if (close < open) {
            generateParenthesis(n, result, str + ")", open, close + 1);
        }
    }
}
