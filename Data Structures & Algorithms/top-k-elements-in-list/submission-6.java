class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        PriorityQueue<Tuple> q = new PriorityQueue<>(Collections.reverseOrder());
        Map<Integer, Integer> map = new HashMap<>();
        int[] res = new int[k];
        for (int num : nums) {
            map.putIfAbsent(num, 0);
            map.put(num, map.get(num) + 1);
        }
        for (int key : map.keySet()) {
            q.offer(new Tuple(key, map.get(key)));
        }
        for (int i = 0; i < k; i++) {
            res[i] = q.poll().num;
        }
        return res;
    }

    public record Tuple(int num, int count) implements Comparable<Tuple>{
        public int compareTo(Tuple other) {
            return this.count - other.count;
        }
    }
}
