/*
@Copyright:LintCode
@Author:   cindyyao
@Problem:  http://www.lintcode.com/problem/flatten-binary-tree-to-linked-list
@Language: Java
@Datetime: 17-03-12 21:41
*/

/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */
public class Solution {
    /**
     * @param root: a TreeNode, the root of the binary tree
     * @return: nothing
     */
    public void flatten(TreeNode root) {
        // write your code here
        if (root == null){
            return;
        }
        flatten(root.left);
        flatten(root.right);
        TreeNode lastNode = getLast(root.left);
        if (lastNode != null) {
            lastNode.right = root.right;
            root.right = root.left;
            root.left = null;
        }
    }
    
    private TreeNode getLast(TreeNode root) {
        TreeNode result = null;
        if (root == null) {
            return result;
        }
        TreeNode curNode = root;
        while (curNode.right != null) {
            curNode = curNode.right;
        }
        return curNode;
    }
}