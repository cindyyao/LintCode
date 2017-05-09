/*
@Copyright:LintCode
@Author:   cindyyao
@Problem:  http://www.lintcode.com/problem/drop-eggs
@Language: Java
@Datetime: 17-03-13 05:06
*/

public class Solution {
    /**
     * @param n an integer
     * @return an integer
     */
    public int dropEggs(int n) {
        long ans = 0;
        for (long i = 1; ; i++) {
            ans = ans + i;
            if (ans >= n) {
                return (int)i;
            }
        }
    }
}