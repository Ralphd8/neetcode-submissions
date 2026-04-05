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
    public boolean isValidBST(TreeNode root) {
        List<Integer> res = new ArrayList<>();
		inter(root,res);
        for(int i = 0 ;i<res.size()-1;i++) {
        	if(res.get(i) >= res.get(i+1)) {
        		return false;
        	}
        }
        return true;
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
