/*
@Copyright:LintCode
@Author:   cindyyao
@Problem:  http://www.lintcode.com/problem/two-sum-less-than-or-equal-to-target
@Language: Java
@Datetime: 17-03-23 04:08
*/

public class Solution {
    /**
     * @param nums an array of integer
     * @param target an integer
     * @return an integer
     */
    public int twoSum5(int[] nums, int target) {
        // Write your code here
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums);
        int pairs = 0;
        for (int i = 0; i < nums.length && nums[i] <= target / 2; i++) {
            int loc = findLocation(nums, target - nums[i], i);
            pairs += loc - i;
        }
        return pairs;
    }
    private int findLocation(int[] nums, int target, int i) {
        if (nums[i + 1] > target) {
            return i;
        }
        int low = i + 1;
        int high = nums.length - 1;
        while (low + 1 < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] <= target) {
                low = mid;
            } else {
                high = mid;
            }
        }
        if (nums[high] <= target) {
            return high;
        }
        return low;
    }
}