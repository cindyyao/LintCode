/*
@Copyright:LintCode
@Author:   cindyyao
@Problem:  http://www.lintcode.com/problem/top-k-largest-numbers-ii
@Language: Java
@Datetime: 17-03-26 05:34
*/

public class Solution {
    public int k;
    public PriorityQueue<Integer> minheap;

    public Solution(int k) {
        // initialize your data structure here.
        this.k = k;
        this.minheap = new PriorityQueue<Integer>(k, new Comparator<Integer>() {
            public int compare(Integer a, Integer b) {
                if (a > b) {
                    return -1;
                } else if (a < b) {
                    return 1;
                } else {
                    return 0;
                }
            }
        });
    }

    public void add(int num) {
        // Write your code here
        minheap.offer(num);
    }

    public List<Integer> topk() {
        // Write your code here
        List<Integer> result = new ArrayList<>();
        int size = minheap.size();
        for (int i = 0; i < Math.min(size, k); i++) {
            result.add(minheap.poll());
        }
        for (int i = 0; i < result.size(); i++) {
            minheap.offer(result.get(i));
        }
        return result;
    }
};