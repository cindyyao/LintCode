/*
@Copyright:LintCode
@Author:   cindyyao
@Problem:  http://www.lintcode.com/problem/maximum-subarray
@Language: Java
@Datetime: 17-04-06 01:25
*/

public class Solution {
    /**
     * @param nums: A list of integers
     * @return: A integer indicate the sum of max subarray
     */
    public int maxSubArray(int[] nums) {
        // write your code
        int sum = 0;
        int start = 0;
        int largestSum = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum > largestSum) {
                largestSum = sum;
            }
            if (sum < 0) {
                if (sum > largestSum) {
                    largestSum = sum;
                }
                start = i + 1;
                sum = 0;
            }
        }
        return largestSum;
    }
}