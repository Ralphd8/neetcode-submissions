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
    public List<Integer> rightSideView(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        List<Integer> res = new ArrayList<>();
        if(root == null) {
        	return res;
        }
        q.add(root);
        while(q.size() != 0) {
        	List<TreeNode> nodes = new ArrayList<>();
        	while(q.size() != 0) {
        		if(q.size() == 1) {
        			res.add(q.peek().val);
        		}
        		nodes.add(q.remove());
        	}
        	
        	
        	for(TreeNode node : nodes) {
        		if(node.left != null) {
        			q.add(node.left);
        		}
        		if(node.right != null) {
        			q.add(node.right);
        		}
        	}
        }
        
        return res;
    }
}
