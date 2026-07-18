/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    int max = Integer.MIN_VALUE;
    public int recursion(TreeNode root){
        if(root == null){
            return 0;
        }
        int leftHeight = recursion(root.left);
        int rightHeight = recursion(root.right);
        max = Math.max(max,leftHeight+rightHeight);
        return 1 + Math.max(leftHeight,rightHeight);
    }
    public int diameterOfBinaryTree(TreeNode root) {
        recursion(root);
        return max;
    }
}
