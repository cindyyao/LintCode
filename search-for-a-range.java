/*
@Copyright:LintCode
@Author:   cindyyao
@Problem:  http://www.lintcode.com/problem/search-for-a-range
@Language: Java
@Datetime: 17-03-28 04:09
*/

public class Solution {
    /** 
     *@param A : an integer sorted array
     *@param target :  an integer to be inserted
     *return : a list of length 2, [index1, index2]
     */
    public int[] searchRange(int[] A, int target) {
        // write your code here
        int[] result = new int[2];
        result[0] = -1;
        result[1] = -1;
        if (A == null || A.length == 0) {
            return result;
        }
        int low = 0;
        int high = A.length - 1;
        while (low + 1 < high) {
            int mid = low + (high - low) / 2;
            if (A[mid] >= target) {
                high = mid;
            } else {
                low = mid;
            }
        }
        if (A[low] == target) {
            result[0] = low;
        } else if (A[high] == target) {
            result[0] = high;
        } else {
            return result;
        }
        low = result[0];
        high = A.length - 1;
        while (low + 1 < high) {
            int mid = low + (high - low) / 2;
            if (A[mid] <= target) {
                low = mid;
            } else {
                high = mid;
            }
        }
        if (A[high] == target) {
            result[1] = high;
        } else {
            result[1] = low;
        }
        return result;
    }
}
