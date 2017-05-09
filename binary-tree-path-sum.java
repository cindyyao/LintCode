/*
@Copyright:LintCode
@Author:   cindyyao
@Problem:  http://www.lintcode.com/problem/binary-tree-path-sum
@Language: Java
@Datetime: 17-03-12 20:33
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
     * @param target an integer
     * @return all valid paths
     */
    public ArrayList<ArrayList<Integer>> binaryTreePathSum(TreeNode root, int target) {
        // Write your code here
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if (root == null) {
            return result;
        }
        if (root.left == null && root.right == null){
            if (root.val == target){
                ArrayList<Integer> newArray = new ArrayList<>();
                newArray.add(root.val);
                result.add(newArray);
            }
            return result;
        }
        
        ArrayList<ArrayList<Integer>> left = binaryTreePathSum(root.left, target - root.val);
        ArrayList<ArrayList<Integer>> right = binaryTreePathSum(root.right, target - root.val);
        if (left.size() > 0){
            for (ArrayList<Integer> path : left) {
                ArrayList<Integer> newArray = new ArrayList<>(path);
                newArray.add(0, root.val);
                result.add(newArray);
            }
        }
        if (right.size() > 0) {
            for (ArrayList<Integer> path : right) {
                ArrayList<Integer> newArray = new ArrayList<>(path);
                newArray.add(0, root.val);
                result.add(newArray);
            }
        }
        return result;
    }
}