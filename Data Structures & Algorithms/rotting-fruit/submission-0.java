class Solution {

    public int orangesRotting(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        int freshOranges = 0;

        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                if (grid[row][col] == 2) {
                    q.add(new int[]{row, col});
                } else if (grid[row][col] == 1) {
                    freshOranges++;
                }
            }
        }

        int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
        int min = 0;

        while (!q.isEmpty() && freshOranges > 0) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                int[] cell = q.remove();
                int r = cell[0];
                int c = cell[1];

                for (int[] dir : dirs) {
                    int nr = r + dir[0];
                    int nc = c + dir[1];

                    if (nr >= 0 && nr < rows && nc >= 0 && nc < cols && grid[nr][nc] == 1) {
                        grid[nr][nc] = 2;
                        freshOranges--;
                        q.add(new int[]{nr, nc});
                    }
                }
            }
            min++;
        }

        if (freshOranges == 0) {
            return min;
        } else {
            return -1;
        }
    }
}
