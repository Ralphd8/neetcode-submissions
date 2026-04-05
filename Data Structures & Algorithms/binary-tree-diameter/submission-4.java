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
        if(root == null){
            return 0;
        }
        if(root.left == null && root.right == null){
            return 1;
        }
        int left = 1 + depth(root.left);
        int right = 1 + depth(root.right);
        if(left > right){
            return left;
        }
        else{
            return right;
        }
    }
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null){
            return 0;
        }
        if(root.left == null && root.right == null){
            return 0;
        }
        int current = depth(root.left) + depth(root.right) ;
        int left= diameterOfBinaryTree(root.left);
        int right= diameterOfBinaryTree(root.right);

        if(current >= left && current >= right){
            return current;
        }
        else if(right >= left){
            return right;
        }
        else{
            return left;
        }
    }
}
