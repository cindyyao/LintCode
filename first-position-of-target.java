/*
@Copyright:LintCode
@Author:   cindyyao
@Problem:  http://www.lintcode.com/problem/first-position-of-target
@Language: Java
@Datetime: 17-03-28 03:08
*/

class Solution {
    /**
     * @param nums: The integer array.
     * @param target: Target to find.
     * @return: The first position of target. Position starts from 0.
     */
    public int binarySearch(int[] nums, int target) {
        //write your code here
        int pos = -1;
        if (nums == null || nums.length == 0){
            return pos;
        }
        int low = 0;
        int high = nums.length - 1;
        while (low + 1 < high){
            int mid = (low + high) / 2;
            if (target <= nums[mid]){
                high = mid;
            } else {
                low = mid;
            }
        }
        if (nums[low] == target) {
            return low;
        } else if (nums[high] == target) {
            return high;
        } else {
            return -1;
        }
    }
}