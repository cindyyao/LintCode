/*
@Copyright:LintCode
@Author:   cindyyao
@Problem:  http://www.lintcode.com/problem/sort-colors-ii
@Language: Java
@Datetime: 17-03-24 03:11
*/

class Solution {
    /**
     * @param nums: A list of integer which is 0, 1 or 2 
     * @return: nothing
     */
    public void sortColors2(int[] nums, int k) {
        // write your code here
        if (nums == null || nums.length <= 1) {
            return;
        }
        quickSort(nums, 0, nums.length - 1);
        return;
    }
    private void quickSort(int[] nums, int low, int high) {
        if (low >= high) {
            return;
        }
        int left = low;
        int right = high;
        int pivot = nums[low + (high - low) / 2];
        while (left <= right) {
            while (left <= right && nums[left] < pivot) {
                left++;
            }
            while (left <= right && nums[right] > pivot) {
                right--;
            }
            if (left <= right) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
                right--;
            }
        }
        quickSort(nums, low, right);
        quickSort(nums, left, high);
        return;
    }
}