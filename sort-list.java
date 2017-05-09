/*
@Copyright:LintCode
@Author:   cindyyao
@Problem:  http://www.lintcode.com/problem/sort-list
@Language: Java
@Datetime: 17-03-22 05:28
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
     * @param head: The head of linked list.
     * @return: You should return the head of the sorted linked list,
                    using constant space complexity.
     */
    public ListNode sortList(ListNode head) {  
        // write your code here
        if (head == null || head.next == null) {
            return head;
        }
        ListNode mid = findMiddle(head);
        ListNode right = sortList(mid.next);
        mid.next = null;
        ListNode left = sortList(head);
        return merge(left, right);
    }
    
    private ListNode findMiddle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    private ListNode merge(ListNode left, ListNode right) {
        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }
        ListNode pointerLeft = left;
        ListNode pointerRight = right;
        ListNode pointerMerge = new ListNode(0);
        ListNode merge = pointerMerge;
        if (left.val < right.val) {
            pointerMerge.val = left.val;
            pointerLeft = pointerLeft.next;
        } else {
            pointerMerge.val = right.val;
            pointerRight = pointerRight.next;
        }
        while (pointerLeft != null && pointerRight != null) {
            if (pointerLeft.val < pointerRight.val) {
                pointerMerge.next = pointerLeft;
                pointerLeft = pointerLeft.next;
            } else {
                pointerMerge.next = pointerRight;
                pointerRight = pointerRight.next;
            }
            pointerMerge = pointerMerge.next;
        }
        if (pointerLeft == null) {
            pointerMerge.next = pointerRight;
        } else {
            pointerMerge.next = pointerLeft;
        }
        return merge;
    }
}
