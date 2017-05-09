/*
@Copyright:LintCode
@Author:   cindyyao
@Problem:  http://www.lintcode.com/problem/remove-duplicate-numbers-in-array
@Language: Java
@Datetime: 17-03-23 03:52
*/

public class Solution {
    /**
     * @param nums an array of integers
     * @return the number of unique integers
     */
    public int deduplication(int[] nums) {
        // Write your code here
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums);
        ArrayList<Integer> indexDup = new ArrayList<>();
        ArrayList<Integer> indexUnique = new ArrayList<>();
        indexUnique.add(0);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i-1]) {
                indexDup.add(i);
            } else {
                indexUnique.add(0, i);
            }
        }
        for (int i = 0; i < indexDup.size(); i++) {
            if (indexDup.get(i) < indexUnique.get(i)) {
                int temp = nums[indexDup.get(i)];
                nums[indexDup.get(i)] = nums[indexUnique.get(i)];
                nums[indexUnique.get(i)] = temp;
            } else {
                break;
            }
        }
        return indexUnique.size();
    }
}