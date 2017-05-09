/*
@Copyright:LintCode
@Author:   cindyyao
@Problem:  http://www.lintcode.com/problem/triangle
@Language: Java
@Datetime: 17-03-26 22:53
*/

public class Solution {
    /**
     * @param triangle: a list of lists of integers.
     * @return: An integer, minimum path sum.
     */
    public int minimumTotal(int[][] triangle) {
        // write your code here
        if (triangle == null || triangle.length == 0) {
            return 0;
        }
        int m = triangle.length;
        int[][] minSum = new int[m][m];
        minSum[0][0] = triangle[0][0];
        for (int i = 1; i < m; i++) {
            minSum[i][0] = minSum[i - 1][0] + triangle[i][0];
            minSum[i][i] = minSum[i - 1][i - 1] + triangle[i][i];
        }
        for (int i = 2; i < m; i++){
            for (int j = 1; j < i; j++) {
                minSum[i][j] = Math.min(minSum[i - 1][j - 1], minSum[i - 1][j]) + triangle[i][j];
            }
        }
        int min = minSum[m - 1][0];
        for (int i = 1; i < m; i++) {
            if (minSum[m - 1][i] < min) {
                min = minSum[m - 1][i];
            }
        }
        return min;
    }
}
