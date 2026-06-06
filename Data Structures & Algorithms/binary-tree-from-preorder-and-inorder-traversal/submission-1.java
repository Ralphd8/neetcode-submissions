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
        if(preorder.length == 0){
            return null;
        }
        TreeNode node = new TreeNode(preorder[0]);
        
        int pos = 0;
        while(inorder[pos] != preorder[0]){
            pos++;
        }
        int[] preLeft = Arrays.copyOfRange(preorder,1,1+pos);
        int[] preRight = Arrays.copyOfRange(preorder,1+pos,preorder.length);

        int[] inLeft = Arrays.copyOfRange(inorder,0,pos);
        int[] inRight = Arrays.copyOfRange(inorder,pos+1,inorder.length);

        node.left = buildTree(preLeft,inLeft);
        node.right = buildTree(preRight,inRight);

        return node;
 
    }
}
