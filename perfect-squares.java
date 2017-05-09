/*
@Copyright:LintCode
@Author:   cindyyao
@Problem:  http://www.lintcode.com/problem/perfect-squares
@Language: Java
@Datetime: 17-03-26 23:43
*/

public class Solution {
    /**
     * @param n a positive integer
     * @return an integer
     */
    public int numSquares(int n) {
        // Write your code here
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int[] square = new int[n + 1];
        square[0] = 0;
        square[1] = 1;
        for (int i = 2; i <= n; i++) {
            int largestSquare = (int)Math.sqrt(i);
            int leastSquare = (int)Math.sqrt(i / 2);
            int min = Integer.MAX_VALUE;
            for (int j = largestSquare; j >= leastSquare; j--) {
                if (square[i - (int)Math.pow(j, 2)] < min) {
                    min = square[i - (int)Math.pow(j, 2)];
                }
            }
            square[i] = min + 1;
        }
        return square[n];
    }
}