/*
@Copyright:LintCode
@Author:   cindyyao
@Problem:  http://www.lintcode.com/problem/merge-k-sorted-lists
@Language: Java
@Datetime: 17-03-26 16:02
*/

/**
 * Definition for ListNode.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int val) {
 *         this.val = val;
 *         this.next = null;
 *     }
 * }
 */ 
public class Solution {
    /**
     * @param lists: a list of ListNode
     * @return: The head of one sorted list.
     */
    public ListNode mergeKLists(List<ListNode> lists) {  
        // write your code here
        Queue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < lists.size(); i++) {
            ListNode node = lists.get(i);
            while (node != null) {
                queue.offer(node.val);
                node = node.next;
            }
        }
        if (queue.isEmpty()) {
            return null;
        }
        ListNode sorted = new ListNode(queue.poll());
        ListNode pointer = sorted;
        while (!queue.isEmpty()) {
            pointer.next = new ListNode(queue.poll());
            pointer = pointer.next;
        }
        return sorted;
    }
}
