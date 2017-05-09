/*
@Copyright:LintCode
@Author:   cindyyao
@Problem:  http://www.lintcode.com/problem/climbing-stairs
@Language: Java
@Datetime: 17-03-26 22:20
*/

public class Solution {
    /**
     * @param n: An integer
     * @return: An integer
     */
    public int climbStairs(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int[] path = new int[n];
        path[0] = 1;
        path[1] = 2;
        for (int i = 2; i < n; i++) {
            path[i] = path[i - 1] + path[i - 2];
        }
        return path[n - 1];
    }
}