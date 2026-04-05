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
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> subList = new ArrayList<>();
        List<TreeNode> subTreeList = new ArrayList<>();
        if(root == null){return list;}
        q.add(root);
        while(q.size() != 0){
            subList.add(q.peek().val);
            subTreeList.add(q.poll());

            if(q.size() == 0){
                list.add(new ArrayList<>(subList)); 
                subList.clear();
                for(TreeNode n : subTreeList){
                    if(n.left != null){
                        q.add(n.left);
                    }
                    if(n.right != null){
                        q.add(n.right);
                    }
                }
                subTreeList.clear();
            }
        }

        return list;
    }
}
