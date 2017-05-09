/*
@Copyright:LintCode
@Author:   cindyyao
@Problem:  http://www.lintcode.com/problem/closest-number-in-sorted-array
@Language: Java
@Datetime: 17-03-08 19:39
*/

public class Solution {
    /**
     * @param A an integer array sorted in ascending order
     * @param target an integer
     * @return an integer
     */
    public int closestNumber(int[] A, int target) {
        // Write your code here
        if (A.length == 0 || A == null){
            return -1;
        }
        int low = 0;
        int high = A.length - 1;
        while(low + 1 < high){
            int mid = low + (high - low) / 2;
            if (target > A[mid]){
                low = mid;
            }
            if (target < A[mid]){
                high = mid;
            }
            if (target == A[mid]){
                return mid;
            }
        }
        int lowDis = target - A[low];
        int highDis = A[high] - target;
        if (lowDis <= highDis){
            return low;
        }
        else {
            return high;
        }
    }
}