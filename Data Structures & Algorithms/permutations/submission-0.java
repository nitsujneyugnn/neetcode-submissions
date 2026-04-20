class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> numsA = new ArrayList<>();
        for (int num : nums) {
            numsA.add(num);
        }
        permute(numsA, result, new ArrayList<>());
        return result;
    }

    private void permute(List<Integer> nums, List<List<Integer>> result, List<Integer> list) {
        if (nums.size() == 0) {
            List<Integer> l = new ArrayList<>();
            for (int num : list) {
                l.add(num);
            }
            result.add(l);
        } else if (nums.size() > 0) {
            for (int i = 0; i < nums.size(); i++) {
                list.add(nums.remove(i));
                permute(nums, result, list);
                nums.add(i, list.remove(list.size() - 1));
            }
        }
    }
}
