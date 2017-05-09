/*
@Copyright:LintCode
@Author:   cindyyao
@Problem:  http://www.lintcode.com/problem/binary-tree-inorder-traversal
@Language: Java
@Datetime: 17-03-09 06:18
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
     * @return: Inorder in ArrayList which contains node values.
     */
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        // write your code here
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null){
            return result;
        }
        result = inorderTraversalHelper(root.left, result);
        result.add(root.val);
        result = inorderTraversalHelper(root.right, result);
        return result;
    }
    
    private ArrayList<Integer> inorderTraversalHelper(TreeNode root, ArrayList<Integer> result){
        if (root == null){
            return result;
        }
        result = inorderTraversalHelper(root.left, result);
        result.add(root.val);
        result = inorderTraversalHelper(root.right, result);
        return result;
    }
}