/*
@Copyright:LintCode
@Author:   cindyyao
@Problem:  http://www.lintcode.com/problem/3sum
@Language: Java
@Datetime: 17-03-24 03:45
*/

public class Solution {
    /**
     * @param numbers : Give an array numbers of n integer
     * @return : Find all unique triplets in the array which gives the sum of zero.
     */
    public ArrayList<ArrayList<Integer>> threeSum(int[] numbers) {
        // write your code here
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (numbers == null || numbers.length < 3) {
            return result;
        }
        Arrays.sort(numbers);
        for (int i = 0; i < numbers.length - 2; i++) {
            if (i > 0 && numbers[i] == numbers[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < numbers.length - 1; j++) {
                if (j > i + 1 && numbers[j] == numbers[j - 1]) {
                    continue;
                }
                int target = - numbers[i] - numbers[j];
                if (target < numbers[j + 1] || target > numbers[numbers.length - 1]) {
                    continue;
                }
                int k = findSum(numbers, target, j + 1);
                if (numbers[i] + numbers[j] + numbers[k] == 0) {
                    ArrayList<Integer> temp = new ArrayList<>();
                    temp.add(numbers[i]);
                    temp.add(numbers[j]);
                    temp.add(numbers[k]);
                    result.add(temp);
                }
            }
        }
        return result;
    }
    private int findSum(int[] numbers, int target, int start) {
        int low = start;
        int high = numbers.length - 1;
        while (low + 1 < high) {
            int mid = low + (high - low) / 2;
            if (numbers[mid] < target) {
                low = mid;
            } else if (numbers[mid] > target) {
                high = mid;
            } else {
                return mid;
            }
        }
        if (numbers[low] == target) {
            return low;
        } else if (numbers[high] == target) {
            return high;
        }
        return start;
    }
}