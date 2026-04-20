class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.putIfAbsent(num, 0);
            map.put(num, map.get(num) + 1);
        }

        List<Integer>[] resKey = new List[nums.length + 1];

        for (int i = 0; i < nums.length + 1; i++) {
            resKey[i] = new ArrayList<>();
        }

        for (int key : map.keySet()) {
            int val = map.get(key);
            resKey[val].add(key);
        }

        int[] res = new int[k]; 
        int n = 0;
        for (int i = resKey.length - 1; i >= 0; i--) {
            if (resKey[i].size() != 0 && n < k) {
                for (int j = 0; j < resKey[i].size(); j++) {
                    res[n] = resKey[i].get(j);
                    n++;
                }
            }
        }

        return res;
    }
}
