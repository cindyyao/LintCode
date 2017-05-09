/*
@Copyright:LintCode
@Author:   cindyyao
@Problem:  http://www.lintcode.com/problem/top-k-largest-numbers
@Language: Java
@Datetime: 17-03-25 18:43
*/

class Solution {
    /*
     * @param nums an integer array
     * @param k an integer
     * @return the top k largest numbers in array
     */
     public int[] topk(int[] nums, int k) {
         PriorityQueue<Integer> minheap = new PriorityQueue<Integer>(k, new Comparator<Integer>() {
             public int compare(Integer o1, Integer o2) {
                 if(o1 < o2) {
                     return 1;
                 } else if(o1 > o2) {
                     return -1;
                 } else {
                     return 0;
                 }
             }
         });

         for (int i : nums) {
             minheap.add(i);
         }

         int[] result = new int[k];
         for (int i = 0; i < result.length; i++) {
             result[i] = minheap.poll();
         }
         return result;
    }
};

