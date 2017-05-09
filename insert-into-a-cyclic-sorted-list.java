/*
@Copyright:LintCode
@Author:   cindyyao
@Problem:  http://www.lintcode.com/problem/insert-into-a-cyclic-sorted-list
@Language: Java
@Datetime: 17-03-20 04:41
*/

/**
 * Definition for ListNode
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    /**
     * @param node a list node in the list
     * @param x an integer
     * @return the inserted new list node
     */
    public ListNode insert(ListNode node, int x) {
        // Write your code here
        if (node == null) {
            ListNode newNode = new ListNode(x);
            newNode.next = newNode;
            return newNode;
        }
        ListNode currNode = node;
        
        while (!(currNode.val <= x && currNode.next.val >= x)) {
            //System.out.println(currNode.val + " " + currNode.next.val);
            currNode = currNode.next;
            if (currNode == node) {
                break;
            }
            if (currNode.val <= x && currNode.val > currNode.next.val) {
                break;
            }
            if (currNode.next.val >= x && currNode.val > currNode.next.val) {
                break;
            }
            
        }
        ListNode newNode = new ListNode(x);
        newNode.next = currNode.next;
        currNode.next = newNode;
        return currNode;
    }
}