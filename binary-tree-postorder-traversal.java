/*
@Copyright:LintCode
@Author:   cindyyao
@Problem:  http://www.lintcode.com/problem/binary-tree-postorder-traversal
@Language: Java
@Datetime: 17-03-09 06:21
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
     * @return: Postorder in ArrayList which contains node values.
     */
    public ArrayList<Integer> postorderTraversal(TreeNode root) {
        // write your code here
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null){
            return result;
        }
        result = postorderTraveralHelper(root.left, result);
        result = postorderTraveralHelper(root.right, result);
        result.add(root.val);
        return result;
    }
    private ArrayList<Integer> postorderTraveralHelper(TreeNode root, ArrayList<Integer> result){
        if (root == null){
            return result;
        }
        result = postorderTraveralHelper(root.left, result);
        result = postorderTraveralHelper(root.right, result);
        result.add(root.val);
        return result;
    }
}