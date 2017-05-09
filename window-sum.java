/*
@Copyright:LintCode
@Author:   cindyyao
@Problem:  http://www.lintcode.com/problem/window-sum
@Language: Java
@Datetime: 17-03-26 00:52
*/

public class Solution {
    /**
     * @param nums a list of integers.
     * @return the sum of the element inside the window at each moving.
     */
    public int[] winSum(int[] nums, int k) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return new int[0];
        }
        int[] result = new int[nums.length - k + 1];
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        result[0] = sum;
        for (int i = 1; i < nums.length - k + 1; i++) {
            result[i] = result[i - 1] - nums[i - 1] + nums[i + k - 1];
        }
        return result;
    }
}

