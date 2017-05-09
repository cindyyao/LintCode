/*
@Copyright:LintCode
@Author:   cindyyao
@Problem:  http://www.lintcode.com/problem/k-closest-numbers-in-sorted-array
@Language: Java
@Datetime: 17-03-31 02:13
*/

public class Solution {
    /**
     * @param A an integer array
     * @param target an integer
     * @param k a non-negative integer
     * @return an integer array
     */
    public int[] kClosestNumbers(int[] A, int target, int k) {
        // Write your code here
        int[] result = new int[k];
        if (A == null || A.length == 0 || k == 0) {
            return result;
        }
        int low = 0;
        int high = A.length - 1;
        int closest = 0;
        while (low + 1 < high) {
            int mid = low + (high - low) / 2;
            if (A[mid] < target) {
                low = mid;
            } else {
                high = mid;
            }
        }
        if (Math.abs(A[low] - target) <= Math.abs(A[high] - target)) {
            closest = low;
        } else {
            closest = high;
        }
        result[0] = A[closest];
        int i = closest + 1;
        int j = closest - 1;
        for (int m = 1; m < k; m++) {
            if (i >= A.length) {
                result[m] = A[j];
                j--;
            } else if (j < 0) {
                result[m] = A[i];
                i++;
            } else if (Math.abs(A[i] - target) < Math.abs(A[j] - target)) {
                result[m] = A[i];
                i++;
            } else {
                result[m] = A[j];
                j--;
            }
        } 
        return result;
    }
}