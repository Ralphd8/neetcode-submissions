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
    public int kthSmallest(TreeNode root, int k) {
        ArrayList<Integer> arr = new ArrayList<>();
        bfs(root,arr);
        return arr.get(k-1);
    }
    public void bfs(TreeNode root, ArrayList<Integer> arr){
        if(root == null){return;}
        bfs(root.left,arr);
        arr.add(root.val);
        bfs(root.right,arr);
    }
}
