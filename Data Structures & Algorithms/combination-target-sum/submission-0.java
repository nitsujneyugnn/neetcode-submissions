class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();

        helper(nums, target, result, new ArrayList<>(), 0, 0);

        return result;
    }

    private void helper(int[] nums, int target, List<List<Integer>> result, List<Integer> list, int sum, int index) {
        if (sum == target) {
            List<Integer> combination = new ArrayList<>();
            for (int num : list) {
                combination.add(num);
            }
            result.add(combination);
        } else if (sum < target) {
            for (int i = index; i < nums.length; i++) {
                list.add(nums[index]);
                sum += nums[index];
                helper(nums, target, result, list, sum, index);
                list.remove(list.size() - 1);
                sum -= nums[index];
                index++;
            }
        }
    }


}
