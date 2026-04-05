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
		List<Integer> res = new ArrayList<>();
		inter(root,res);
		return res.get(k-1);
    }
	
	public void inter(TreeNode root,List<Integer> res) {
		if(root == null) {
			return;
		}
		
		inter(root.left,res);
		res.add(root.val);
		inter(root.right,res);
	}
}
