/*
@Copyright:LintCode
@Author:   cindyyao
@Problem:  http://www.lintcode.com/problem/search-in-rotated-sorted-array
@Language: Java
@Datetime: 17-03-06 05:10
*/

public class Solution {
    /** 
     *@param A : an integer rotated sorted array
     *@param target :  an integer to be searched
     *return : an integer
     */
    public int search(int[] A, int target) {
        // write your code here
        int result = -1;
        if (A.length == 0 || A == null){
            return result;
        }
        int low = 0;
        int high = A.length - 1;
        if (A[0] > A[A.length - 1]){
            while (low + 1 < high) {
                int mid = low + (high - low) / 2;
                if (A[mid] > A[0]) {
                    low = mid;
                }
                else {
                    high = mid;
                }
            }
            int start = high;
            if (target < A[0]){
                low = start;
                high = A.length - 1;
            }
            else {
                low = 0;
                high = start - 1;
            }
        }
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (A[mid] > target) {
                high = mid - 1;
            }
            else if (A[mid] < target){
                low = mid + 1;
            }
            else {
                low = mid + 1;
                result = mid;
            }
        }
        return result;
    }
}
