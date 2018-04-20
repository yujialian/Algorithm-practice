class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
        int n = matrix[0].length;
        int l = 0, r = matrix.length * matrix[0].length - 1;
        while(l <= r) {
            int mid = l + (r-l) / 2;
            if(matrix[mid/n][mid%n] == target) {
                return true;
            } else if(matrix[mid/n][mid%n] > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return false;
    }
}
