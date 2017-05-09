/*
@Copyright:LintCode
@Author:   cindyyao
@Problem:  http://www.lintcode.com/problem/kth-largest-element-ii
@Language: Java
@Datetime: 17-03-25 18:30
*/

class Solution {
    /**
     * @param nums an integer unsorted array
     * @param k an integer from 1 to n
     * @return the kth largest element
     */
    public int kthLargestElement2(int[] nums, int k) {
        // Write your code here
        for (int i = 1; i < k; i++) {
            int index = i;
            while (index > 0 && nums[index] > nums[index - 1]) {
                swap(nums, index, index - 1);
                index--;
            }
        }
        for (int i = k; i < nums.length; i++) {
            if (nums[i] > nums[k - 1]) {
                swap(nums, i, k - 1);
                int index = k - 1;
                while (index > 0 && nums[index] > nums[index - 1]) {
                    swap(nums, index, index - 1);
                    index--;
                }
            }
        }
        return nums[k - 1];
    }
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
        return;
    }
};