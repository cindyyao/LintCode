/*
@Copyright:LintCode
@Author:   cindyyao
@Problem:  http://www.lintcode.com/problem/combination-sum-ii
@Language: Java
@Datetime: 17-03-17 05:32
*/

public class Solution {
    public List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] num, int target) {
        // write your code here

        if (num.length == 0) {
            return result;
        }
        Arrays.sort(num);
        List<Integer> currArray = new ArrayList<>();
        Helper(num, target, currArray);
        return result;
    }

    private List<Integer> Helper(int[] num, int target, List<Integer> currArray) {

        if (num.length == 0) {
            return new ArrayList<>();
        }
        for (int i = 0; i < num.length; i++) {
            if (i > 0 && num[i-1] == num[i]) {
                continue;
            }
            currArray.add(num[i]);
            if (target < num[i]) {
                currArray.remove(currArray.size()-1);
                if (currArray.size() > 0) {
                    currArray.remove(currArray.size()-1);
                }
                return currArray;
            }
            if (target == num[i]) {
                result.add(new ArrayList<>(currArray));
                currArray.remove(currArray.size()-1);
                if (currArray.size() > 0) {
                    currArray.remove(currArray.size()-1);
                }
                return currArray;
            }
            if (target > num[i]) {
                int[] numNew = new int[num.length - i - 1];
                System.arraycopy(num, i + 1, numNew, 0, num.length - i - 1);
                currArray = Helper(numNew, target - num[i], currArray);
            }
        }
        return currArray;
    }
}
