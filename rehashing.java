/*
@Copyright:LintCode
@Author:   cindyyao
@Problem:  http://www.lintcode.com/problem/rehashing
@Language: Java
@Datetime: 17-03-26 16:37
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
     * @param hashTable: A list of The first node of linked list
     * @return: A list of The first node of linked list which have twice size
     */    
    public ListNode[] rehashing(ListNode[] hashTable) {
        // write your code here
        ArrayList<Integer> nodes = new ArrayList<>();
        for (int i = 0; i < hashTable.length; i++) {
            ListNode node = hashTable[i];
            while (node != null) {
                nodes.add(node.val);
                node = node.next;
            }
        }
        int size = nodes.size();
        int capacity = hashTable.length;
        capacity *= 2;
        ListNode[] newTable = new ListNode[capacity];
        for (int i = 0; i < capacity; i++) {
            newTable[i] = null;
        }
        for (int i = nodes.size() - 1; i >= 0; i--) {
            int key = nodes.get(i) % capacity;
            if (key < 0) {
                key += capacity;
            }
            if (newTable[key] == null) {
                newTable[key] = new ListNode(nodes.get(i));
            } else {
                ListNode temp = new ListNode(nodes.get(i));
                temp.next = newTable[key];
                newTable[key] = temp;
            }
        }
        return newTable;
    }
};
