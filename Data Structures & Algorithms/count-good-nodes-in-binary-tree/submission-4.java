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
    int count = 0;
    public void DFS(TreeNode root,int max){
        if(root == null){return;}
        if(root.val >= max){
            count++;
            DFS(root.left,root.val);
            DFS(root.right,root.val);
        }
        else{
            DFS(root.left,max);
            DFS(root.right,max);
        }
    }
    public int goodNodes(TreeNode root) {
        if(root == null){return count;}
        DFS(root,root.val);
        return count;
    }
}
