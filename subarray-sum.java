/*
@Copyright:LintCode
@Author:   cindyyao
@Problem:  http://www.lintcode.com/problem/subarray-sum
@Language: Java
@Datetime: 17-04-06 01:19
*/

public class Solution {
    /**
     * @param nums: A list of integers
     * @return: A list of integers includes the index of the first number 
     *          and the index of the last number
     */
    public ArrayList<Integer> subarraySum(int[] nums) {
        // write your code here
        ArrayList<Integer> result = new ArrayList<>();
        HashMap<Integer, Integer> mapping = new HashMap<>();
        int sum = 0;
        mapping.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (!mapping.containsKey(sum)) {
                mapping.put(sum, i);
            } else {
                result.add(mapping.get(sum) + 1);
                result.add(i);
                return result;
            }
        }
        return result;
    }
}