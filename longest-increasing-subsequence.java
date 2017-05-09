/*
@Copyright:LintCode
@Author:   cindyyao
@Problem:  http://www.lintcode.com/problem/longest-increasing-subsequence
@Language: Java
@Datetime: 17-03-27 02:10
*/

public class Solution {
    /**
     * @param nums: The integer array
     * @return: The length of LIS (longest increasing subsequence)
     */
    public int longestIncreasingSubsequence(int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] longest = new int[nums.length];
        longest[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            int max = 0;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j] && longest[j] > max) {
                    max = longest[j];
                }
            }
            longest[i] = max + 1;
        }
        int max = 1;
        for (int i = 0; i < nums.length; i++) {
            if (longest[i] > max) {
                max = longest[i];
            }
        }
        return max;
    }
}
