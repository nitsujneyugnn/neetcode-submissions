class Solution {
    public int climbStairs(int n) {
        int total = 0;
        if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        } else {
            int prev = 1;
            int temp = 2;
            total = 2;
            for (int i = 0; i < n - 2; i++) {
                total += prev;
                prev = temp;
                temp = total;
            }
            return total;
        }
    }
}
