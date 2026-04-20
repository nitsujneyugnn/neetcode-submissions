class Solution {
    public boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];

        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                if (word.charAt(0) == board[row][col]) {
                    if (exist(board, visited, word, row, col, 0)) {
                        return true;
                    } else {
                        visited = new boolean[board.length][board[0].length];
                    }
                }
            }
        }
        return false;
    }

    private boolean exist(char[][] board, boolean[][] visited, String word, int row, int col, int index) {
        if (row < 0 || row >= board.length || 
            col < 0 || col >= board[row].length ||
            board[row][col] != word.charAt(index) ||
            visited[row][col]) {
            return false;
        }
        visited[row][col] = true;
        if (index == word.length() - 1) {
            return true;
        } 

        boolean found = exist(board, visited, word, row + 1, col, index + 1) ||
                exist(board, visited, word, row - 1, col, index + 1) ||
                exist(board, visited, word, row , col + 1, index + 1) ||
                exist(board, visited, word, row , col - 1, index + 1);

        visited[row][col] = false;

        return found;
    }
}
