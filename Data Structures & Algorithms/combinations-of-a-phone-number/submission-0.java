class Solution {
    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return new ArrayList<>();
        }

        List<String> res = new ArrayList<>();

        Map<Integer, String> map = new HashMap<>();
        map.put(2, "abc");
        map.put(3, "def");
        map.put(4, "ghi");
        map.put(5, "jkl");
        map.put(6, "mno");
        map.put(7, "pqrs");
        map.put(8, "tuv");
        map.put(9, "wxyz");

        letterCombinations(res, digits, 0, "", map);

        return res;
    }

    private void letterCombinations(List<String> res, String digits, int index, String soFar, Map<Integer, String> map) {
        if (index == digits.length()) {
            res.add(String.valueOf(soFar));
        } else if (index < digits.length()) {
            char c = digits.charAt(index);
            String curr = map.get(c - '0');
            for (int i = 0; i < curr.length(); i++) {
                soFar += Character.toString(curr.charAt(i));
                letterCombinations(res, digits, index + 1, soFar, map);
                soFar = soFar.substring(0, soFar.length() - 1);
            }

        }
    }
}
