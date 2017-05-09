/*
@Copyright:LintCode
@Author:   cindyyao
@Problem:  http://www.lintcode.com/problem/two-sum-closest-to-target
@Language: Java
@Datetime: 17-03-24 02:16
*/

public class Solution {
    /**
     * @param nums an integer array
     * @param target an integer
     * @return the difference between the sum and the target
     */
    public int twoSumClosest(int[] nums, int target) {
        // Write your code here
        if (nums == null || nums.length == 0) {
            return target;
        }
        Arrays.sort(nums);
        int delta = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int diff = closestTarget(nums, target - nums[i], i + 1);
            if (diff == 0) {
                return 0;
            }
            if (diff < delta) {
                delta = diff;
            }
            if (nums[i] > target / 2 + 1) {
                break;
            }
        }
        return delta;
    }
    private int closestTarget(int[] nums, int target, int start) {
        if (start > nums.length - 1) {
            return Integer.MAX_VALUE;
        }
        int low = start;
        int high = nums.length - 1;
        while (low + 1 < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] < target) {
                low = mid;
            } else if (nums[mid] > target) {
                high = mid;
            } else {
                return 0;
            }
        }
        if (Math.abs(target - nums[low]) < Math.abs(nums[high] - target)) {
            return Math.abs(target - nums[low]);
        }
        return Math.abs(nums[high] - target);
    }
}