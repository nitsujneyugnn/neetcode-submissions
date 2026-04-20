class Solution {
    int count = 0;
    int max = 0;
    public int maxAreaOfIsland(int[][] grid) {
        
        Set<Point> visited = new HashSet<>();

        // traverse through grid
        // keep track of visited parts of islands
        // when entering new unvisited land, dfs and count

        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                Point point = new Point(row, col);
                if (!visited.contains(point) && grid[row][col] == 1) {
                    dfs(grid, visited, row, col);
                    max = Math.max(max, count);
                    count = 0;
                }
            }
        }

        return max;
    }

    private void dfs(int[][] grid, Set<Point> visited, int row, int col) {
        visited.add(new Point(row, col));
        count++;
        // Check each side

        if (row - 1 >= 0 && grid[row - 1][col] == 1) {
            if (!visited.contains(new Point(row - 1, col))) {
                dfs(grid, visited, row - 1, col);
            }
        }

        if (row + 1 < grid.length && grid[row + 1][col] == 1) {
            if (!visited.contains(new Point(row + 1, col))) {
                dfs(grid, visited, row + 1, col);
            }
        }

        if (col - 1 >= 0 && grid[row][col - 1] == 1) {
            if (!visited.contains(new Point(row, col - 1))) {
                dfs(grid, visited, row, col - 1);
            }
        }

        if (col + 1 < grid[row].length && grid[row][col + 1] == 1) {
            if (!visited.contains(new Point(row, col + 1))) {
                dfs(grid, visited, row, col + 1);
            }
        }
    }

    public record Point(int x, int y) {}
}
