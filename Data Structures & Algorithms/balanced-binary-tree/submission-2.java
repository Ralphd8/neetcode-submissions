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
    public int depth(TreeNode root){
        if(root == null){return 0;}
        return 1 + Math.max(depth(root.left),depth(root.right));
    }
    public boolean helper(TreeNode root){
        if(root == null){return true;}
        boolean left = helper(root.left);
        boolean right = helper(root.right);
        int dLeft = depth(root.left);
        int dRight = depth(root.right);
        boolean cur = (Math.abs(dLeft - dRight) <= 1) ? true : false;
        return cur && left && right;
    }
    public boolean isBalanced(TreeNode root) {
        return helper(root);
    }
}
