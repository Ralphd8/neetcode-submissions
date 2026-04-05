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
    public int maxDepth(TreeNode root) {
        if(root == null){
            return -1;
        }
        return 1 + Math.max(maxDepth(root.left),maxDepth(root.right));
    }

    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null){
            return 0;
        }
        else if(root.left == null){
            int res = maxDepth(root);
            return Math.max(res,diameterOfBinaryTree(root.right));
        }
        else if(root.right == null){
            int res = maxDepth(root);
            return Math.max(res,diameterOfBinaryTree(root.left));
        }
        else{
            int res = maxDepth(root.left) + maxDepth(root.right) +2;
            return Math.max(res,Math.max(diameterOfBinaryTree(root.left),diameterOfBinaryTree(root.right)));
        }
        
    }
}
