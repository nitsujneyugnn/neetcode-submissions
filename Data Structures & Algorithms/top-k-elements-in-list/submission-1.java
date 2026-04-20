class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int max = 0;
        for (int num : nums) {
            map.putIfAbsent(num, 0);
            map.put(num, map.get(num) + 1);
            if (map.get(num) > max) {
                max = map.get(num);
            }
        }

        int[] result = new int[k];
        int index = 0;

        while (index < result.length) {
            if (map.containsValue(max)) {
                for (int key : map.keySet()) {
                    if (map.get(key) == max) {
                        result[index] = key;
                        index++;
                    }
                }
            }
            max--;
        }

        return result;
    }
}
