/*
@Copyright:LintCode
@Author:   cindyyao
@Problem:  http://www.lintcode.com/problem/recover-rotated-sorted-array
@Language: Java
@Datetime: 17-03-28 04:32
*/

public class Solution {
    /**
     * @param nums: The rotated sorted array
     * @return: void
     */
    public void recoverRotatedSortedArray(ArrayList<Integer> nums) {
        // write your code
        if (nums == null || nums.size() == 0) {
            return;
        }
        int count = 0;
        while (nums.get(0) >= nums.get(nums.size() - 1) && count <= nums.size()) {
            int temp = nums.remove(0);
            nums.add(temp);
            count++;
        }
        return;
    }
}