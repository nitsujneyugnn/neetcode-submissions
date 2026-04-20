class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int max = 0;
        for (int num : nums) {
            set.add(num);
        }

        for (int num : set) {
            if (!set.contains(num - 1)) {
                int start = num;
                int count = 1;
                while (set.contains(start + 1)) {
                    count++;
                    start++;
                }
                if (count > max) {
                    max = count;
                }
            }
        }
        return max;

    }
}
