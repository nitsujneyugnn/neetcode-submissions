class Solution {
    public boolean isValidSudoku(char[][] board) {
       Map<Integer, Set<Character>> map = new HashMap<>();
        Map<Integer, Set<Character>> r = new HashMap<>();
         Map<Integer, Set<Character>> c = new HashMap<>();

       for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                if (board[row][col] != '.') {

                    if (!r.containsKey(col)) {
                        r.put(col, new HashSet<>());
                    }
                    if (r.get(col).contains(board[row][col])) {
                        return false;
                    } else {
                        r.get(col).add(board[row][col]);
                    }

                    if (!c.containsKey(row)) {
                        c.put(row, new HashSet<>());
                    }
                    if (c.get(row).contains(board[row][col])) {
                        return false;
                    } else {
                        c.get(row).add(board[row][col]);
                    }

                    // 3x3 check
                    int index = (row / 3) * 3 + (col / 3);
                    if (!map.containsKey(index)) {
                        map.put(index, new HashSet<>());
                    }
                
                    if (map.get(index).contains(board[row][col])) {
                        return false;
                    }
                    map.get(index).add(board[row][col]);
                }
            }
       }
       return true;
    }
}
