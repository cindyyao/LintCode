/*
@Copyright:LintCode
@Author:   cindyyao
@Problem:  http://www.lintcode.com/problem/lowest-common-ancestor-iii
@Language: Java
@Datetime: 17-03-12 22:38
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
     * @param root The root of the binary tree.
     * @param A and B two nodes
     * @return: Return the LCA of the two nodes.
     */
    public TreeNode lowestCommonAncestor3(TreeNode root, TreeNode A, TreeNode B) {
        // write your code here
        if (root == null) {
            return null;
        }
        
        TreeNode left = lowestCommonAncestor3(root.left, A, B);
        TreeNode right = lowestCommonAncestor3(root.right, A, B);
        if (left != null) {
            return left;
        } else if (right != null) {
            return right;
        } else if (exist(root, A) && exist(root, B)) {
            return root;
        } else {
            return null;
        }
    }
    
    private boolean exist(TreeNode root, TreeNode A) {
        if (root == null) {
            return false;
        }
        if (exist(root.left, A) || exist(root.right, A) || root == A) {
            return true;
        }
        return false;
    }
}