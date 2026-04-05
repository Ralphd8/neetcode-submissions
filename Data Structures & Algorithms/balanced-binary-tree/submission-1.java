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
    public boolean isBalanced(TreeNode root) {
        if(root == null){return true;}
        int right = depth(root.right);
        int left = depth(root.left);
        boolean cur = (Math.abs(right-left) > 1.0) ? false : true;
        boolean r = isBalanced(root.right);
        boolean l = isBalanced(root.left);
        return cur && r && l;
    }
}
