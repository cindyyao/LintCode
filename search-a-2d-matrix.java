/*
@Copyright:LintCode
@Author:   cindyyao
@Problem:  http://www.lintcode.com/problem/search-a-2d-matrix
@Language: Java
@Datetime: 17-03-26 01:03
*/

public class Solution {
    /**
     * @param matrix, a list of lists of integers
     * @param target, an integer
     * @return a boolean, indicate whether matrix contains target
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        // write your code here
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int low = 0;
        int high = matrix.length - 1;
        while (low + 1 < high) {
            int mid = low + (high - low) / 2;
            if (matrix[mid][0] > target) {
                high = mid - 1;
            } else if (matrix[mid][0] < target) {
                low = mid;
            } else {
                return true;
            }
        }
        int row = 0;
        if (matrix[high][0] > target) {
            row = low;
        } else if (matrix[high][0] < target) {
            row = high;
        } else {
            return true;
        }
        low = 0;
        high = matrix[0].length - 1;
        while (low + 1 < high) {
            int mid = low + (high - low) / 2;
            if (matrix[row][mid] < target) {
                low = mid;
            } else if (matrix[row][mid] > target) {
                high = mid;
            } else {
                return true;
            }
        }
        if (matrix[row][low] == target || matrix[row][high] == target) {
            return true;
        }
        return false;
    }
}
