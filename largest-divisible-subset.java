/*
@Copyright:LintCode
@Author:   cindyyao
@Problem:  http://www.lintcode.com/problem/largest-divisible-subset
@Language: Java
@Datetime: 17-03-27 02:26
*/

public class Solution {
    /**
     * @param nums a set of distinct positive integers
     * @return the largest subset 
     */
    public List<Integer> largestDivisibleSubset(int[] nums) {
        // Write your code here
        List<Integer> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        Arrays.sort(nums);
        int len = nums.length;
        int[] longest = new int[len];
        longest[0] = 1;
        for (int i = 1; i < len; i++) {
            int max = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0 && longest[j] > max) {
                    max = longest[j];
                }
            }
            longest[i] = max + 1;
        }
        int max = 1;
        int index = 0;
        for (int i = 0; i < len; i++) {
            if (longest[i] > max) {
                max = longest[i];
                index = i;
            }
        }
        result.add(nums[index]);
        for (int i = index - 1; i >= 0; i--) {
            if (nums[index] % nums[i] == 0) {
                result.add(0, nums[i]);
                index = i;
            }
        }
        return result;
    }
}