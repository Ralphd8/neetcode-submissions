class Solution {
    int max = Integer.MIN_VALUE;

    public int DFS(TreeNode root) {
        if (root == null) return 0;

        int left = Math.max(0, DFS(root.left));
        int right = Math.max(0, DFS(root.right));

        // best path THROUGH this node
        max = Math.max(max, root.val + left + right);

        // return best single path upward
        return root.val + Math.max(left, right);
    }

    public int maxPathSum(TreeNode root) {
        DFS(root);
        return max;
    }
}