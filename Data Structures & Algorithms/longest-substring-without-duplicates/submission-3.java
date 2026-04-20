class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        int left = 0;
        Set<Character> unique = new HashSet<>();
        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            while (unique.contains(c)) {
                unique.remove(s.charAt(left));
                left++;
            }
            unique.add(c);
            if (right - left + 1> max) {
                max = right - left + 1;
            }
        }
        return max;
    }
}
