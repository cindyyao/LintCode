/*
@Copyright:LintCode
@Author:   cindyyao
@Problem:  http://www.lintcode.com/problem/sqrtx-ii
@Language: Java
@Datetime: 17-03-31 04:43
*/

public class Solution {
    /**
     * @param x a double
     * @return the square root of x
     */
    public double sqrt(double x) {
        // Write your code here
        double low = 0;
        double high = Math.max(x, 1);
        double delta = 1e-13;
        double mid = low + (high - low) / 2;
        while (x - mid * mid > delta || mid * mid - x > 0) {
            if (mid * mid > x) {
                high = mid;
            } else {
                low = mid;
            }
            mid = low + (high - low) / 2;
        }
        return mid;
    }
}