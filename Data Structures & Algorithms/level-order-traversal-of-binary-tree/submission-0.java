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
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        q.add(root);
        
        while(q.size() != 0) {
        	List<TreeNode> nodeList = new ArrayList<>();
        	while(q.size() != 0) {
        		nodeList.add(q.remove());
        	}
        	List<Integer> values = new ArrayList<>();
        	for(TreeNode node : nodeList) {
        		values.add(node.val);
        	}
        	res.add(values);
        	for(TreeNode node : nodeList) {
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
