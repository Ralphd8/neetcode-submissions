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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0) return null;
        TreeNode root = new TreeNode(preorder[0]);
        int indexOfRootInInorder = 0;
        for(int i =0; i<inorder.length;i++){
            if(inorder[i] == preorder[0]){
                indexOfRootInInorder = i;
                break;
            }
        }
        root.left = buildTree(Arrays.copyOfRange(preorder,1,1+indexOfRootInInorder), Arrays.copyOfRange(inorder,0,indexOfRootInInorder));
        root.right = buildTree(Arrays.copyOfRange(preorder,1+indexOfRootInInorder,inorder.length), Arrays.copyOfRange(inorder,indexOfRootInInorder+1,inorder.length));

        return root;
    }
}
