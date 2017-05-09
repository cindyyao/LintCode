/*
@Copyright:LintCode
@Author:   cindyyao
@Problem:  http://www.lintcode.com/problem/subarray-sum-closest
@Language: Java
@Datetime: 17-03-20 06:14
*/

public class Solution {
    /**
     * @param nums: A list of integers
     * @return: A list of integers includes the index of the first number 
     *          and the index of the last number
     */
    public int[] subarraySumClosest(int[] nums) {
        // write your code here
        int sum = 0;
        int[] sumSub = new int[nums.length];
        HashMap<Integer, ArrayList<Integer>> mapping = new HashMap<>();
        int distanceMin = Integer.MAX_VALUE;
        int start = 0;
        int end = 0;
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum == 0) {
                result[0] = 0;
                result[1] = i;
                return result;
            }
            sumSub[i] = sum;
            if (!mapping.containsKey(sum)) {
                mapping.put(sum, new ArrayList<Integer>());
            }
            mapping.get(sum).add(i);
            if (Math.abs(sum) < distanceMin) {
                distanceMin = Math.abs(sum);
                end = i;
            }
        }
        //System.out.println(end);
        //System.out.println(printArray(sumSub));
        Arrays.sort(sumSub);
        int distance = Math.abs(sumSub[0]);
        if (distance < distanceMin) {
            end = mapping.get(distance).get(0);
        }
        for (int i = 1; i < sumSub.length; i++) {
            if (sumSub[i] - sumSub[i - 1] < distanceMin) {
                distanceMin = sumSub[i] - sumSub[i - 1];
                if (distanceMin == 0) {
                    result[0] = mapping.get(sumSub[i]).get(1);
                    result[1] = mapping.get(sumSub[i]).get(0);
                    return result;
                }
                start = Math.min(mapping.get(sumSub[i]).get(0), mapping.get(sumSub[i - 1]).get(0)) + 1;
                end = Math.max(mapping.get(sumSub[i]).get(0), mapping.get(sumSub[i - 1]).get(0));
            }
        }
        result[0] = start;
        result[1] = end;
        return result;
    }
    private String printArray(int[] array) {
        String result = "";
        for (int item : array) {
            result = result + item + " ";
        }
        return result;
    } 
}
