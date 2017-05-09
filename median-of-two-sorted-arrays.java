/*
@Copyright:LintCode
@Author:   cindyyao
@Problem:  http://www.lintcode.com/problem/median-of-two-sorted-arrays
@Language: Java
@Datetime: 17-03-22 03:34
*/

class Solution {
    /**
     * @param A: An integer array.
     * @param B: An integer array.
     * @return: a double whose format is *.5 or *.0
     */
    public double findMedianSortedArrays(int[] A, int[] B) {
        // write your code here
        if (A.length == 0 && B.length == 1) {
            return (double)B[0];
        }
        if (A.length == 1 && B.length == 0 ) {
            return (double)A[0];
        }
        int stop = (A.length + B.length) / 2;
        int[] median = new int[2];
        int a = 0;
        int b = 0;
        for (int i = 0; i <= stop; i++) {
            median[0] = median[1];
            if (a == A.length) {
                median[1] = B[b];
                b++;
            } else if (b == B.length) {
                median[1] = A[a];
                a++;
            } else if (A[a] < B[b]) {
                median[1] = A[a];
                a++;
            } else {
                median[1] = B[b];
                b++;
            }
        }
        if ((A.length + B.length) / 2 * 2 == (A.length + B.length)) {
            return (median[0] + median[1]) / 2.0;
        } else {
            return (double)median[1];
        }
    }
}
