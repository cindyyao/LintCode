/*
@Copyright:LintCode
@Author:   cindyyao
@Problem:  http://www.lintcode.com/problem/total-occurrence-of-target
@Language: Java
@Datetime: 17-03-13 03:46
*/

public class Solution {
    /**
     * @param A an integer array sorted in ascending order
     * @param target an integer
     * @return an integer
     */
    public int totalOccurrence(int[] A, int target) {
        if (A == null || A.length == 0) {
            return 0;
        }
        int low = 0;
        int high = A.length - 1;
        int idxLow = 0, idxHigh = 0;
        while (low + 1 < high) {
            int mid = low + (high - low) / 2;
            if (A[mid] < target) {
                low = mid;
            } else {
                high = mid;
            }
        }
        if (A[low] == target) {
            idxLow = low;
        } else if (A[high] == target) {
            idxLow = high;
        } else {
            return 0;
        }
        low = idxLow;
        high = A.length - 1;
        while (low + 1 < high) {
            int mid = low + (high - low) / 2;
            if (A[mid] > target) {
                high = mid;
            } else {
                low = mid;
            }
        }
        if (A[high] == target) {
            idxHigh = high;
        } else if (A[low] == target) {
            idxHigh = low;
        } else {
            return 0;
        }
        return idxHigh - idxLow + 1;
    }
}