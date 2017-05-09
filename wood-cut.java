/*
@Copyright:LintCode
@Author:   cindyyao
@Problem:  http://www.lintcode.com/problem/wood-cut
@Language: Java
@Datetime: 17-03-06 02:20
*/

public class Solution {
    /** 
     *@param L: Given n pieces of wood with length L[i]
     *@param k: An integer
     *return: The maximum length of the small pieces.
     */
    public int woodCut(int[] L, int k) {
        // write your code here
        int result = 0;
        if (L.length == 0 || L == null){
            return result;
        }
        Arrays.sort(L);
        int upper = L[L.length - 1];
        int lower = 1;
        while (lower <= upper){
            int mid = lower + (upper - lower) / 2;
            int piece = 0;
            for (int j = 0; j < L.length; j++){
                piece = piece + L[j] / mid;
            }
            if (piece >= k){
                result = mid;
                lower = mid + 1;
            }
            else {
                upper = mid - 1;
            }
        }
        return result;
    }
}