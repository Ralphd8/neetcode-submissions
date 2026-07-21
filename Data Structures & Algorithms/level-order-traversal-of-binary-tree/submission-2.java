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
        List<List<Integer>> result = new ArrayList<>();
        if(root == null){return result;}
        Deque<TreeNode> queue = new ArrayDeque<>();

        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> arr = new ArrayList<>();
            for(int i=0;i<size;i++){
                TreeNode cur = queue.poll();
                arr.add(cur.val);
                if(cur.left != null){queue.add(cur.left);}
                if(cur.right != null){queue.add(cur.right);}
            }
            result.add(arr);
        }
        return result;
    }
}
