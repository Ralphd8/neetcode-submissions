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
    public int goodNodes(TreeNode root) {
        int res = inter(root,-999999999);
        return res;
    }

    public int inter(TreeNode root, int max){
        if(root == null){
            return 0;
        }
        int res =0;
        if(root.val >= max){
            res++;
        }
        res = res + inter(root.left,Math.max(root.val,max));
        res = res + inter(root.right,Math.max(root.val,max));
        return res;
    }
}
