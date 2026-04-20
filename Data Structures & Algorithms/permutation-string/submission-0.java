class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s2.length() < s1.length()) {
            return false;
        }

        int[] charCount = new int[26];
        
        for (char c : s1.toCharArray()) {
            charCount[c - 'a']++;
        }

        int[] substringCharCount = new int[26];

        int left = 0;
        for (int i = 0; i < s1.length(); i++) {
            char c = s2.charAt(i);
            substringCharCount[c - 'a']++;
        }
        
        while (left + s1.length() <= s2.length()) {
            if (Arrays.equals(charCount, substringCharCount)) {
                return true;
            } else if (left + s1.length() == s2.length()) {
                break;
            }

            substringCharCount[s2.charAt(left) - 'a']--;
            left++;
            substringCharCount[s2.charAt(left + s1.length() - 1) - 'a']++;
        }
        return false;
    }
}
