/*
@Copyright:LintCode
@Author:   cindyyao
@Problem:  http://www.lintcode.com/problem/find-peak-element
@Language: Java
@Datetime: 17-03-06 04:10
*/

class Solution {
    /**
     * @param A: An integers array.
     * @return: return any of peek positions.
     */
    public int findPeak(int[] A) {
        // write your code here
        int low = 0;
        int high = A.length - 1;
        while (low + 2 < high) {
            int mid = low + (high - low) / 2;
            if (A[mid] < A[mid + 1]){
                low = mid;
            }
            else {
                high = mid + 1;
            }
        }
        return low + 1;
    }
}
