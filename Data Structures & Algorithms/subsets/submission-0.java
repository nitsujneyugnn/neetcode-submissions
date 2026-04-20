class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        helper(nums, list, new ArrayList<>(), 0);
        return list;
    }

    private void helper(int[] nums, List<List<Integer>> list, List<Integer> subset, int start) {
        List<Integer> set = new ArrayList<>();
        for (int num : subset) {
            set.add(num);
        }
        list.add(set);
        for (int i = start; i < nums.length; i++) {
            subset.add(nums[i]);
            helper(nums, list, subset, i + 1);
            subset.remove(subset.size() - 1);
        }
    }
}
