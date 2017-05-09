/*
@Copyright:LintCode
@Author:   cindyyao
@Problem:  http://www.lintcode.com/problem/ugly-number-ii
@Language: Java
@Datetime: 17-03-26 15:21
*/

class Solution {
    /**
     * @param n an integer
     * @return the nth prime number as description.
     */
    public int nthUglyNumber(int n) {
        // Write your code here
        int[] ugly = new int[n];
        ugly[0] = 1;
        int p2 = 0;
        int p3 = 0;
        int p5 = 0;
        for (int i = 1; i < n; i++) {
            int lastNumber = ugly[i - 1];
            while (ugly[p2] * 2 <= lastNumber) {
                p2++;
            }
            while (ugly[p3] * 3 <= lastNumber) {
                p3++;
            }
            while (ugly[p5] * 5 <= lastNumber) {
                p5++;
            }
            ugly[i] = Math.min(Math.min(ugly[p2] * 2, ugly[p3] *3), ugly[p5] * 5);
        }
        return ugly[n - 1];
    }
};
