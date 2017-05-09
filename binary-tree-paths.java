/*
@Copyright:LintCode
@Author:   cindyyao
@Problem:  http://www.lintcode.com/problem/binary-tree-paths
@Language: Java
@Datetime: 17-03-10 03:33
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
     * @param root the root of the binary tree
     * @return all root-to-leaf paths
     */
    public List<String> binaryTreePaths(TreeNode root) {
        // Write your code here
        List<String> result = new ArrayList<String>();
        if (root == null){
            return result;
        }
        List<String> leftResult = binaryTreePaths(root.left);
        List<String> rightResult = binaryTreePaths(root.right);
        for (int i = 0; i < leftResult.size(); i++){
            String newPath = root.val + "->" + leftResult.get(i);
            result.add(newPath);
        }
        for (int j = 0; j < rightResult.size(); j++){
            String newPath = root.val + "->" + rightResult.get(j);
            result.add(newPath);
        }
        if (result.size() == 0){
            String newPath = root.val + "";
            result.add(newPath);
        }
        return result;
    }
}