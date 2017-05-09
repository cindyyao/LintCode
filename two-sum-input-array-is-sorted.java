/*
@Copyright:LintCode
@Author:   cindyyao
@Problem:  http://www.lintcode.com/problem/two-sum-input-array-is-sorted
@Language: Java
@Datetime: 17-03-23 04:21
*/

public class Solution {
    /*
     * @param nums an array of Integer
     * @param target = nums[index1] + nums[index2]
     * @return [index1 + 1, index2 + 1] (index1 < index2)
     */
    public int[] twoSum(int[] nums, int target) {
        // write your code here
        int[] index = new int[2];
        for (int i = 0; i < nums.length && nums[i] <= target / 2; i++) {
            index[0] = i;
            index[1] = findLocation(nums, target - nums[i], i);
            if (index[1] > 0) {
                break;
            }
        }
        index[0]++;
        index[1]++;
        return index;
    }
    private int findLocation(int[] nums, int target, int i) {
        if (nums[i+1] > target) {
            return -1;
        }
        int low = i + 1;
        int high = nums.length - 1;
        while (low + 1 < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] < target) {
                low = mid;
            } else if (nums[mid] > target) {
                high = mid;
            } else {
                return mid;
            }
        }
        if (nums[low] == target) {
            return low;
        }
        if (nums[high] == target) {
            return high;
        }
        return -1;
    }
}