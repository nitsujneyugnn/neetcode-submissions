class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int stone : stones) {
            pq.offer(stone);
        }
        while (pq.size() >= 2) {
            int x = pq.poll();
            int y = pq.poll();
            if (x < y) {
                y = y - x;
                pq.offer(y);
            } else if (y < x) {
                x = x - y;
                pq.offer(x);
            }
        }

        if (pq.size() == 1) {
            return pq.peek();
        } else {
            return 0;
        }
    }
}
