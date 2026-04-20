class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int maxSize = 0;
        for (int i = 0; i < piles.length; i++) {
            maxSize = Math.max(piles[i], maxSize);
        }

        int min = 1;

        while (min < maxSize) {
            int k = (maxSize + min) / 2;

            int total = 0;
            for (int p : piles) {
                total += (p + k - 1) / k;
            }

            if (total <= h) {
                maxSize = k;
            } else {
                min = k + 1;
            }
        }

        return (maxSize + min) / 2;
    }
}
