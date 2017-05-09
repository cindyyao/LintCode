/*
@Copyright:LintCode
@Author:   cindyyao
@Problem:  http://www.lintcode.com/problem/copy-books
@Language: Java
@Datetime: 17-03-07 03:57
*/

public class Solution {
    /**
     * @param pages: an array of integers
     * @param k: an integer
     * @return: an integer
     */
    public int copyBooks(int[] pages, int k) {
        // write your code here
        if (pages.length == 0 || pages == null){
            return 0;
        }
        int total = 0;
        int max = pages[0];
        for (int i = 0; i < pages.length; i++){
            total = total + pages[i];
            if (pages[i] > max){
                max = pages[i];
            } 
        }
        int low = max;
        int high = total;
        int result = total;
        while (low <= high){
            int mid = low + (high - low) / 2;
            if (k < countCopier(pages, mid)){
                low = mid + 1;
            }
            else {
                high = mid - 1;
                result = mid;
            }
        }
        return result;
    }
    
    private int countCopier(int[] pages, int finishTime) {
        int sum = 0;
        int copier = 1;
        for (int i = 0; i < pages.length; i++) {
            if (sum + pages[i] > finishTime){
                copier++;
                sum = 0;
            }
            sum = sum + pages[i];
        }
        return copier;
    }
}