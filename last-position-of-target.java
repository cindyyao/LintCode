/*
@Copyright:LintCode
@Author:   cindyyao
@Problem:  http://www.lintcode.com/problem/last-position-of-target
@Language: Java
@Datetime: 17-03-28 03:10
*/

public class Solution {
    /**
     * @param nums: An integer array sorted in ascending order
     * @param target: An integer
     * @return an integer
     */
    public int lastPosition(int[] nums, int target) {
        // Write your code here
        int pos = -1;
        if (nums == null || nums.length == 0){
            return pos;
        }
        
        int low = 0;
        int high = nums.length - 1;
        while (low + 1 < high){
            int mid = (low + high)/2;
            if (nums[mid] <= target){
                low = mid;
            } else {
                high = mid;
            }
        }
        if (nums[high] == target) {
            return high;
        } else if (nums[low] == target) {
            return low;
        } else {
            return -1;
        }
    }
}