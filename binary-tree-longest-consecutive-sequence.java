/*
@Copyright:LintCode
@Author:   cindyyao
@Problem:  http://www.lintcode.com/problem/binary-tree-longest-consecutive-sequence
@Language: Java
@Datetime: 17-03-12 19:54
*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    /**
     * @param root the root of binary tree
     * @return the length of the longest consecutive sequence path
     */
    private int longestPath = 0;
    
    public int longestConsecutive(TreeNode root) {
        // Write your code here
        if (root == null){
            return longestPath;
        }
        int curPath = 1;
        Helper(root.left, root.val, curPath);
        Helper(root.right, root.val, curPath);
        return longestPath;
    }
    
    private void Helper(TreeNode root, int parentVal, int curPath) {
        if (root == null){
            return;
        }
        if (root.val == parentVal + 1) {
            curPath++;
        } 
        if (curPath > longestPath) {
            longestPath = curPath;
        }
        if (root.val != parentVal + 1) {
            curPath = 1;
        }
        Helper(root.left, root.val, curPath);
        Helper(root.right, root.val, curPath);
    }
}