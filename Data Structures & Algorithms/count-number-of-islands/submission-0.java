class Solution {
    // DFS search
    // Keep track of visited coordinates
    // Look for unvisited islands, when find DFS
    // searching for other unvisited parts of the islands
    // Have a total number of islands tracker
    // Return total
    public int numIslands(char[][] grid) {
        int total = 0;
        Set<Point> visited = new HashSet<>();

        // Traverse through 2D array
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                Point point = new Point(row, col);
                // Check if unvisited island, DFS if is
                if (!visited.contains(point) && grid[row][col] == '1') {
                    dfs(grid, visited, point);
                    total++;
                }
            }
        }


        return total;
    }

    // Checks and marks the rest of the island segments of this island
    private void dfs(char[][] grid, Set<Point> visited, Point point) {
        visited.add(point);
        // Want to check all adjacent points

        // Check if not edge, then if upper neighbor is unvisited island
        if (point.x - 1 >= 0) {
            char up = grid[point.x - 1][point.y];
            Point p = new Point(point.x - 1, point.y);
            if (up == '1' && !visited.contains(p)) {
                dfs(grid, visited, new Point(point.x - 1, point.y));
            }
        }

        if (point.x + 1 < grid.length) {
            Point p = new Point(point.x + 1, point.y);
            if (grid[point.x + 1][point.y] == '1' && !visited.contains(p)) {
                dfs(grid, visited, new Point(point.x + 1, point.y));
            }
        }

        if (point.y + 1 < grid[point.x].length) {
            Point p = new Point(point.x, point.y + 1);
            if (grid[point.x] [point.y + 1] == '1' && !visited.contains(p)) {
                dfs(grid, visited, new Point(point.x, point.y + 1));
            }
        }

        if (point.y - 1 >= 0) {
            char up = grid[point.x][point.y - 1];
            Point p = new Point(point.x, point.y - 1);
            if (up == '1' && !visited.contains(p)) {
                dfs(grid, visited, new Point(point.x, point.y - 1));
            }
        }
    }

    public record Point(int x, int y) {}
}
