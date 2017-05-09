/*
@Copyright:LintCode
@Author:   cindyyao
@Problem:  http://www.lintcode.com/problem/minimum-subtree
@Language: Java
@Datetime: 17-03-10 04:16
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
     * @param root the root of binary tree
     * @return the root of the minimum subtree
     */
    private int minSum = Integer.MAX_VALUE;
    private TreeNode minTree = null;
    
    public TreeNode findSubtree(TreeNode root) {
        // Write your code here
        getSum(root);
        return minTree;
    }
    
    private int getSum(TreeNode root){
        if (root == null){
            return 0;
        }
        int sum = getSum(root.left) + getSum(root.right) + root.val;
        if (sum < minSum){
            minSum = sum;
            minTree = root;
        }
        return sum;
    }
}