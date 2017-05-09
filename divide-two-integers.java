/*
@Copyright:LintCode
@Author:   cindyyao
@Problem:  http://www.lintcode.com/problem/divide-two-integers
@Language: Java
@Datetime: 17-03-31 03:44
*/

public class Solution {
    /**
     * @param dividend the dividend
     * @param divisor the divisor
     * @return the result
     */
    public int divide(int dividend, int divisor) {
        // Write your code here
        if (divisor == 0) {
            return Integer.MAX_VALUE;
        }
        long dividendP = Math.abs((long)dividend);
        long divisorP = Math.abs((long)divisor);
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        int result = 0;
        while (dividendP >= divisorP) {
            int shift = 1;
            while (dividendP >= (divisorP << shift)) {
                shift++;
            }
            result += 1 << (shift - 1);
            dividendP -= divisorP << (shift - 1);
        }
        if ((dividend <= 0 && divisor > 0) || (dividend >= 0 && divisor < 0)) {
            result = -result;
        }
        return result;
    }
}