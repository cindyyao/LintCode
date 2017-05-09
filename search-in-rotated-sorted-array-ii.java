/*
@Copyright:LintCode
@Author:   cindyyao
@Problem:  http://www.lintcode.com/problem/search-in-rotated-sorted-array-ii
@Language: Java
@Datetime: 17-03-31 04:23
*/

public class Solution {
    /** 
     * param A : an integer ratated sorted array and duplicates are allowed
     * param target :  an integer to be search
     * return : a boolean 
     */
    public boolean search(int[] A, int target) {
        // write your code here
        if (A == null || A.length == 0) {
            return false;
        }
        int start = 0;
        for (int i = 0; i < A.length - 1; i++) {
            if (A[i + 1] < A[i]) {
                start = i + 1;
                break;
            }
        }
        int low = 0;
        int high = A.length - 1;
        if (target <= A[A.length - 1]) {
            low = start;
        } else {
            high = start - 1;
        }
        if (high < 0) {
            return false;
        }
        while (low + 1 < high) {
            int mid = low + (high - low) / 2;
            if (A[mid] < target) {
                low = mid;
            } else {
                high = mid;
            }
        }
        if (A[low] == target || A[high] == target) {
            return true;
        }
        return false;
    }
}
