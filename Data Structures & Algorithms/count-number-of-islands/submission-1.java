class Solution {
    public int numIslands(char[][] grid) {
        // must keep track for each piece of land, if we visited that part of island
        // hashset to keep track of visited
        // iterate through grid
        // if is 1 and not visited, then increment island count and find rest of island segments
        // return
        int islands = 0;
        Set<Point> visited = new HashSet<>();
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                if (grid[row][col] == '1' && !visited.contains(new Point(row, col))) {
                    dfs(row, col, visited, grid);
                    islands++;
                }
            }
        }
        return islands;
    }

    public void dfs(int row, int col, Set<Point> visited, char[][] grid) {
        if (row >= 0 && row < grid.length && col >= 0 && col < grid[row].length && grid[row][col] == '1' &&
            !visited.contains(new Point(row, col))) {
            visited.add(new Point(row, col));
            dfs(row + 1, col, visited, grid);
            dfs(row, col + 1, visited, grid);
            dfs(row - 1, col, visited, grid);
            dfs(row, col - 1, visited, grid);
        }
    }

    public record Point(int x, int y) {}
}
