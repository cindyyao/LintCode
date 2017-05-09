/*
@Copyright:LintCode
@Author:   cindyyao
@Problem:  http://www.lintcode.com/problem/partition-array
@Language: Java
@Datetime: 17-03-24 04:06
*/

public class Solution {
	/** 
     *@param nums: The integer array you should partition
     *@param k: As description
     *return: The index after partition
     */
    public int partitionArray(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
	    //write your code here
	    int left = 0;
	    int right = nums.length - 1;
	    while (left <= right) {
	        while (left <= right && nums[left] < k) {
	            left++;
	            if (left == nums.length) {
	                return nums.length;
	            }
	        }
	        while (left <= right && nums[right] >= k) {
	            right--;
	            if (right < 0) {
	                return 0;
	            }
	        }
	        if (left < right) {
    	        int temp = nums[left];
    	        nums[left] = nums[right];
    	        nums[right] = temp;
    	        left++;
    	        right--;
	        }
	    }
	    if (nums[right] >= k) {
	        return right;
	    }
	    return left;
    }
}