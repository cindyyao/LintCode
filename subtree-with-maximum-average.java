/*
@Copyright:LintCode
@Author:   cindyyao
@Problem:  http://www.lintcode.com/problem/subtree-with-maximum-average
@Language: Java
@Datetime: 17-03-10 05:25
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
     * @return the root of the maximum average of subtree
     */
    private double maxAvg = Double.NEGATIVE_INFINITY;
    private TreeNode maxNode = null;
    public TreeNode findSubtree2(TreeNode root) {
        // Write your code here
        getAvg(root);
        return maxNode;
    }
    
    private double getAvg(TreeNode root){
        if (root == null){
            return 0;
        }
        int leftNodeNum = getNodeNum(root.left);
        int rightNodeNum = getNodeNum(root.right);
        double sum = getAvg(root.left) * leftNodeNum + getAvg(root.right) * rightNodeNum + root.val;
        int nodeNum = leftNodeNum + rightNodeNum + 1; 
        double avg = sum / nodeNum;
        if (avg > maxAvg){
            maxAvg = avg;
            maxNode = root;
        }
        return avg;
    }
    
    private int getNodeNum(TreeNode root){
        if (root == null){
            return 0;
        }
        else {
            return getNodeNum(root.left) + getNodeNum(root.right) + 1;
        }
    }
}