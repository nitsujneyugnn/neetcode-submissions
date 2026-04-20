class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Point> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for (int i = 0; i < points.length; i++) {
            int x = points[i][0];
            int y = points[i][1];
            double distance = x * x + y * y;
            Point point = new Point(distance, x, y);
            pq.offer(point);
            if (pq.size() > k) {
                pq.poll();
            }
        }

        int[][] res = new int[k][2];
        int i = 0;
        while (!pq.isEmpty()) {
            Point point = pq.poll();
            res[i][0] = point.x();
            res[i][1] = point.y();
            i++;
        }
        
        return res;
    }

    public record Point(double distance, int x, int y) implements Comparable<Point> {
        public int compareTo(Point other) {
            return (int) (this.distance() - other.distance());
        }
    }
}
