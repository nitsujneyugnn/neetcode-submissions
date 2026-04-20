class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        helper(candidates, target, result, new ArrayList<>(), 0, 0);
        return result;
    }

    private void helper(int[] candidates, int target, List<List<Integer>> result, List<Integer> list, int index, int sum) {
        if (sum == target) {
            List<Integer> valid = new ArrayList<>();
            for (int num : list) {
                valid.add(num);
            }
            result.add(valid);
        } else if (sum < target) {
            for (int i = index; i < candidates.length; i++) {
                if (i > index && candidates[i] == candidates[i - 1]) {
                    continue;
                }
                list.add(candidates[i]);
                sum += candidates[i];
                helper(candidates, target, result, list, i + 1, sum);
                list.remove(list.size() - 1);
                sum -= candidates[i];
            }
        }
    }
}
