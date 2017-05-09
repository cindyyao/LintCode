/*
@Copyright:LintCode
@Author:   cindyyao
@Problem:  http://www.lintcode.com/problem/search-a-2d-matrix-ii
@Language: Java
@Datetime: 17-03-28 04:02
*/

public class Solution {
    /**
     * @param matrix: A list of lists of integers
     * @param: A number you want to search in the matrix
     * @return: An integer indicate the occurrence of target in the given matrix
     */
    public int searchMatrix(int[][] matrix, int target) {
        // write your code here
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int count = 0;
        int low = 0;
        int high = matrix.length - 1;
        int i = 0;
        while (high >= 0 && i < matrix[0].length) {
            while (low + 1 < high) {
                int mid = low + (high - low) / 2;
                if (matrix[mid][i] < target) {
                    low = mid;
                } else if (matrix[mid][i] > target) {
                    high = mid;
                } else {
                    high = mid;
                }
            }
            if (matrix[low][i] == target) {
                high = low - 1;
                count++;
            } else if (matrix[high][i] == target) {
                high = low;
                count++;
            } else if (matrix[low][i] > target) {
                high = low - 1;
            } else if (matrix[high][i] > target) {
                high = low;
            }
            low = 0;
            i++;
        }
        return count;
    }
}
