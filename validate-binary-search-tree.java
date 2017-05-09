/*
@Copyright:LintCode
@Author:   cindyyao
@Problem:  http://www.lintcode.com/problem/validate-binary-search-tree
@Language: Java
@Datetime: 17-03-12 22:02
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
     * @param root: The root of binary tree.
     * @return: True if the binary tree is BST, or false
     */
    public boolean isValidBST(TreeNode root) {
        // write your code here
        if (root == null) {
            return true;
        }
        if (root.left == null && root.right == null) {
            return true;
        }
        
        if (isValidBST(root.left) && isValidBST(root.right)) {
            if (root.left != null && max(root.left) >= root.val){
                return false;
            }
            if (root.right != null && min(root.right) <= root.val) {
                return false;
            }
            return true;
        }
        return false;
    }
    
    private int max(TreeNode root) {
        if (root == null) {
            return Integer.MIN_VALUE;
        }
        int left = max(root.left);
        int right = max(root.right);
        return Math.max(Math.max(left, right), root.val);
    }
    private int min(TreeNode root) {
        if (root == null) {
            return Integer.MAX_VALUE;
        }
        int left = min(root.left);
        int right = min(root.right);
        return Math.min(Math.min(left, right), root.val);
    }
}