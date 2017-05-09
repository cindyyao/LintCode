/*
@Copyright:LintCode
@Author:   cindyyao
@Problem:  http://www.lintcode.com/problem/permutations
@Language: Java
@Datetime: 17-03-17 23:06
*/

class Solution {
    /**
     * @param nums: A list of integers.
     * @return: A list of permutations.
     */
    public List<List<Integer>> result = new ArrayList<>();
    public ArrayList<Integer> currArray = new ArrayList<>();
    
    public List<List<Integer>> permute(int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0) {
            result.add(new ArrayList<Integer>());
            return result;
        }
        ArrayList<Integer> numsArray = new ArrayList<>();
        for (int i : nums) {
            numsArray.add(i);
        }
        Helper(numsArray);
        return result;
    }
    private void Helper(ArrayList<Integer> numsArray) {
        if (numsArray.size() == 0) {
            result.add(new ArrayList<Integer>(currArray));
            currArray.remove(currArray.size() - 1);
            return;
        }
        for (int i = 0; i < numsArray.size(); i++) {
            currArray.add(numsArray.get(i));
            ArrayList<Integer> numsLeft = new ArrayList<Integer>(numsArray);
            numsLeft.remove(i);
            Helper(numsLeft);
        }
        if (currArray.size() > 0) {
            currArray.remove(currArray.size() - 1);
        }
        return;
    }
}
