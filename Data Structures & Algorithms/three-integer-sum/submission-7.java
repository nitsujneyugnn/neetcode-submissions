class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int target = -nums[i];
            int l = i + 1;
            int r = nums.length - 1;
            while (l < r) {
                 int curSum = nums[l] + nums[r];
                 if (curSum > target) {
                    r--;
                 } else if (curSum < target) {
                    l++;
                 } else {
                    List<Integer> triplet = new ArrayList<>(List.of(nums[i], nums[l], nums[r]));
                    if (!result.contains(triplet)) {
                        result.add(triplet);
                    }
                    l++;
                 }
            }
        }
        return result;
    }
}
