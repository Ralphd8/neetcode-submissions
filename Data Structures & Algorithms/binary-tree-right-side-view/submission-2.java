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
        List<Integer> res = new ArrayList<>();
        if(root == null){return res;}
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        List<TreeNode> treeList =new ArrayList<>();

        while(q.size() != 0){
            if(q.size() == 1){
                res.add(q.peek().val);
            }
            treeList.add(q.poll());
            if(q.size() == 0){
                for(TreeNode n : treeList){
                    if (n.left != null){q.add(n.left);}
                    if (n.right != null){q.add(n.right);}
                }
                treeList.clear();
            }
        }
        return res;
    }
}
