class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rowLow = 0;
        int rowHigh = matrix.length - 1;
        int row = 0;
        while (rowLow <= rowHigh) {
            int rowMid = (rowLow + rowHigh) / 2;
            if (matrix[rowMid][0] <= target && target <= matrix[rowMid][matrix[rowMid].length - 1]) {
                row = rowMid;
                break;
            } else if (target <= matrix[rowMid][0]) {
                rowHigh = rowMid - 1;
            } else {
                rowLow = rowMid + 1;
            }
        }
        int low = 0;
        int high = matrix[row].length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (matrix[row][mid] == target) {
                return true;
            } else if (matrix[row][mid] >= target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return false;
    }
}
