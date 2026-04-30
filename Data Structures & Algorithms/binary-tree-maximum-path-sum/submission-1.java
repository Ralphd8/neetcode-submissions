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
    public int DFS(TreeNode root){
        if(root == null) return 0;
        if(root.val > max) max = root.val;
        int left = DFS(root.left);
        int right = DFS(root.right);
        if(root.val + left + right > max) max = root.val + left + right;
        if(root.val + left > max) max = root.val + left;
        if(root.val + right > max) max = root.val +right;
        if(left < 0 && right < 0){
            return root.val;
        } 
        else{
            return root.val + Math.max(left,right);
        }
    }
    public int maxPathSum(TreeNode root) {
        DFS(root);
        return max;
    }
}
