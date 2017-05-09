/*
@Copyright:LintCode
@Author:   cindyyao
@Problem:  http://www.lintcode.com/problem/two-sum-unique-pairs
@Language: Java
@Datetime: 17-03-24 01:57
*/

public class Solution {
    /**
     * @param nums an array of integer
     * @param target an integer
     * @return an integer
     */
    public int twoSum6(int[] nums, int target) {
        // Write your code here
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums);
        int pairs = 0;
        for (int i = 0; i < nums.length && nums[i] <= target / 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            if (existTarget(nums, target - nums[i], i + 1)) {
                pairs++;
            }
        }
        return pairs;
    }
    
    private boolean existTarget(int[] nums, int target, int start) {
        if (start > nums.length - 1) {
            return false;
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
                return true;
            }
        }
        if (nums[low] == target || nums[high] == target) {
            return true;
        }
        return false;
    }
}