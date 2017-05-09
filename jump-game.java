/*
@Copyright:LintCode
@Author:   cindyyao
@Problem:  http://www.lintcode.com/problem/jump-game
@Language: Java
@Datetime: 17-03-27 00:24
*/

public class Solution {
    /**
     * @param A: A list of integers
     * @return: The boolean answer
     */
    public boolean canJump(int[] A) {
        // wirte your code here
        if (A == null || A.length == 0) {
            return true;
        }
        if (A[0] == 0) {
            if (A.length == 1) {
                return true;
            }
            return false;
        }
        int len = A.length;
        int i = len - 2;
        int j = -1;
        boolean result = true;
        while (i >= 0) {
            if (A[i] == 0) {
                result = false;
                for (j = i - 1; j >= 0; j--) {
                    if (A[j] > i - j) {
                        i = j - 1;
                        result = true;
                        break;
                    }
                }
                if (j < 0) {
                    break;
                }
            } else {
                i--;
            }
        }
        return result;
    }
}
