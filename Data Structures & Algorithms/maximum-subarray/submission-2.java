class Solution {
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int curr = nums[0];
        for (int right = 1; right < nums.length; right++) {
            max = Math.max(curr, max);
            if (curr < 0) {
                curr = nums[right];
            } else {
                curr += nums[right];
            }
        }
        return Math.max(max, curr);
    }
}
