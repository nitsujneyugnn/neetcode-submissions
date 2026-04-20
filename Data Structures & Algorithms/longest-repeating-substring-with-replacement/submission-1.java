class Solution {
    public int characterReplacement(String s, int k) {
        HashMap<Character, Integer> frequent = new HashMap<>();
        int maxChar = 0;
        int max = 0;
        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            frequent.putIfAbsent(s.charAt(right), 0);
            frequent.put(s.charAt(right), frequent.get(s.charAt(right)) + 1);


            if (frequent.get(s.charAt(right)) > maxChar) {
                maxChar = frequent.get(s.charAt(right));
            }

            int replacementsNeeded = right - left + 1 - maxChar;

            while (replacementsNeeded > k) {
                frequent.put(s.charAt(left), frequent.get(s.charAt(left)) - 1);
                left++;
                replacementsNeeded = right - left + 1 - maxChar;
            }
            
            if (right - left + 1 > max) {
                max = right - left + 1;
            }
        }

        return max;
    }
}
