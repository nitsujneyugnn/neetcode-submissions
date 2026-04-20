class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() <= 1) {
            return s.length();
        }
        int max = 0;
        int left = 0;
        Set<Character> unique = new HashSet<>();
        for (int right = 0; right < s.length(); right++) {
            while (unique.contains(s.charAt(right))) {
                unique.remove(s.charAt(left));
                left++;
            }
            unique.add(s.charAt(right));
            if (right - left + 1 > max) {
                max = right - left + 1;
            }
        }
        return max;
    }
}
