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
    public int recursive(TreeNode root,int max){
        if(root == null) return 0;
        if(root.val >= max){
            return 1 + recursive(root.left,root.val) + recursive(root.right,root.val);
        }
        else{
            return recursive(root.left,max) + recursive(root.right,max);
        }
    }
    public int goodNodes(TreeNode root) {
        if(root == null) return 0;
        return recursive(root,root.val);
        

    }
}
