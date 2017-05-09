/*
@Copyright:LintCode
@Author:   cindyyao
@Problem:  http://www.lintcode.com/problem/subsets-ii
@Language: Java
@Datetime: 17-03-03 05:02
*/

class Solution {
    /**
     * @param nums: A set of numbers.
     * @return: A list of lists. All valid subsets.
     */
    public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] nums) {
        // write your code here
        Arrays.sort(nums);
        int SetSize = nums.length;
        if (SetSize == 0 || nums == null) {
            ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
            ArrayList<Integer> a = new ArrayList<>();
            result.add(a);
            return result;
        }
        //int[] test = Arrays.copyOfRange(nums, 1, nums.length);
        //System.out.println(Arrays.toString(test));
        ArrayList<ArrayList<Integer>> result1 = subsetsWithDup(Arrays.copyOfRange(nums, 1, nums.length));
        //System.out.println(result1.size());
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>(result1);
        int i;
        for (i = 0; i < result1.size(); i++) {
            ArrayList<Integer> NewArray = new ArrayList<Integer>(result1.get(i));
            NewArray.add(0, nums[0]);
            boolean unique = true;
            int j;
            for (j = 0; j < result.size(); j++){
                if (NewArray.equals(result.get(j))){
                    unique = false;
                }
            }
            if (unique){
                result.add(NewArray);
            }
        }
        return result;
    }
}
