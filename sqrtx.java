/*
@Copyright:LintCode
@Author:   cindyyao
@Problem:  http://www.lintcode.com/problem/sqrtx
@Language: Java
@Datetime: 17-03-05 20:56
*/

class Solution {
    /**
     * @param x: An integer
     * @return: The sqrt of x
     */
    public int sqrt(int x) {
        // write your code here
        if (x == 0){
            return 0;
        }
        long result = x;
        long X = x;
        while(Math.abs(result - X/result) > 1){
            result = (result + X/result)/2;
        }
        int intResult = (int) result;
        return Math.min(intResult, x/intResult);
    }
}