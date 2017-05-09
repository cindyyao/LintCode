/*
@Copyright:LintCode
@Author:   cindyyao
@Problem:  http://www.lintcode.com/problem/maximum-number-in-mountain-sequence
@Language: Java
@Datetime: 17-03-09 03:15
*/

public class Solution {
    /**
     * @param nums a mountain sequence which increase firstly and then decrease
     * @return then mountain top
     */
    public int mountainSequence(int[] nums) {
        // Write your code here
        int result = nums[0];
        if (nums.length == 1 || nums[0] > nums[1]){
            return result;
        }
        if (nums[nums.length - 1] > nums[nums.length - 2]){
            return nums[nums.length - 1];
        }
        int low = 1;
        int high = nums.length - 2;
        while(low <= high){
            int mid = low + (high - low) / 2;
            if (nums[mid + 1] > nums[mid]){
                low = mid + 1;
            }
            else if (nums[mid - 1] > nums[mid]){
                high = mid - 1;
            }
            else {
                result = nums[mid];
                break;
            }
        }
        return result;
    }
}