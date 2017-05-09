/*
@Copyright:LintCode
@Author:   cindyyao
@Problem:  http://www.lintcode.com/problem/combination-sum
@Language: Java
@Datetime: 17-03-17 16:22
*/

public class Solution {
    public List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] num, int target) {
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
        //System.out.println(printArray(currArray));
        //System.out.println(Arrays.toString(num));
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
                //System.out.print("[" + printArray(currArray) + "]");
                result.add(new ArrayList<>(currArray));
                currArray.remove(currArray.size()-1);
                if (currArray.size() > 0) {
                    currArray.remove(currArray.size()-1);
                }
                return currArray;
            }
            if (target > num[i]) {
                int[] numNew = new int[num.length - i];
                System.arraycopy(num, i, numNew, 0, num.length - i);
                currArray = Helper(numNew, target - num[i], currArray);
            }
        }
        if (currArray.size() > 0) {
            currArray.remove(currArray.size()-1);
        }
        return currArray;
    }
    private String printArray(List<Integer> array) {
        String str = "";
        for (int i = 0; i < array.size(); i++) {
            str = str + array.get(i) + ",";
        }
        return str.substring(0,str.length()-1);
    }
}
