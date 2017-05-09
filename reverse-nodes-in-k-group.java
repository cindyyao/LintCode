/*
@Copyright:LintCode
@Author:   cindyyao
@Problem:  http://www.lintcode.com/problem/reverse-nodes-in-k-group
@Language: Java
@Datetime: 17-04-06 04:14
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    /**
     * @param head a ListNode
     * @param k an integer
     * @return a ListNode
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        // Write your code here
        if (head == null || k == 1) {
            return head;
        }
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        while (prev.next != null) {
            prev = reverseNextKth(prev, k);
        }
        return dummy.next;
    }
    private ListNode reverseNextKth(ListNode prev, int k) {
        ListNode node = prev;
        for (int i = 0; i < k; i++) {
            if (node.next == null) {
                return node;
            }
            node = node.next;
        }
        ListNode nodeKPlus = node.next;
        ListNode nodePrev = prev;
        ListNode nodeFirst = prev.next;
        ListNode curr = nodeFirst;
        for (int i = 0; i < k; i++) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        nodeFirst.next = curr;
        nodePrev.next = prev;
        return nodeFirst;
    }
}