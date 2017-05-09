/*
@Copyright:LintCode
@Author:   cindyyao
@Problem:  http://www.lintcode.com/problem/find-minimum-in-rotated-sorted-array
@Language: Java
@Datetime: 17-03-06 03:45
*/

public class Solution {
    /**
     * @param nums: a rotated sorted array
     * @return: the minimum number in the array
     */
    public int findMin(int[] nums) {
        // write your code here
        if (nums[0] < nums[nums.length - 1]) {
            return nums[0];
        }
        int low = 0;
        int high = nums.length - 1;
        while (low + 1 < high){
            int mid = low + (high - low)/2;
            if (nums[mid] > nums[low]){
                low = mid;
            }
            else {
                high = mid;
            }
        }
        return nums[high];
    }
}