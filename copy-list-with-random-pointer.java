/*
@Copyright:LintCode
@Author:   cindyyao
@Problem:  http://www.lintcode.com/problem/copy-list-with-random-pointer
@Language: Java
@Datetime: 17-03-22 02:54
*/

/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    /**
     * @param head: The head of linked list with a random pointer.
     * @return: A new head of a deep copy of the list.
     */
    public RandomListNode copyRandomList(RandomListNode head) {
        // write your code here
        // copy nodes
        RandomListNode copyHead = new RandomListNode(head.label);
        HashMap<RandomListNode, RandomListNode> mapping = new HashMap<>();
        mapping.put(head, copyHead);
        RandomListNode currNode = head.next;
        while (currNode != null && currNode != head) {
            RandomListNode copyCurr = new RandomListNode(currNode.label);
            mapping.put(currNode, copyCurr);
            currNode = currNode.next;
        }
        
        // copy links
        if (head.next == null) {
            copyHead.next = null;
            if (head.random == null) {
                copyHead.random = null;
            } else {
                copyHead.random = copyHead;
            }
            return copyHead;
        }
        mapping.get(head).next = mapping.get(head.next);
        if (head.random == null) {
            mapping.get(head).random = null;
        } else {
            mapping.get(head).random = mapping.get(head.random);
        }
        currNode = head.next;
        while (currNode != null && currNode != head) {
            if (currNode.next == null) {
                mapping.get(currNode).next = null;
            } else {
                mapping.get(currNode).next = mapping.get(currNode.next);
            }
            if (currNode.random == null) {
                mapping.get(currNode).random = null;
            } else {
                mapping.get(currNode).random = mapping.get(currNode.random);
            }
            currNode = currNode.next;
        }
        return copyHead;
    }
}