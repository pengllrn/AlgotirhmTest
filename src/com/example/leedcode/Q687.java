package com.example.leedcode;

/**
 * @author Pengllrn
 * @since <pre>2019/6/13 11:45</pre>
 */
public class Q687 {
}

class Solution687 {
    private int ans;

    public int longestUnivaluePath(TreeNode root) {
        dfs(root);
        return ans;
    }

    private int dfs(TreeNode root) {
        if (root == null)
            return 0;
        int left = dfs(root.left);
        int right = dfs(root.right);
        int leftPath = root.left != null && root.val == root.left.val ? left + 1 : 0;
        int rightPath = root.right != null && root.val == root.right.val ? right + 1 : 0;

        ans = Math.max(ans, leftPath + rightPath);
        return Math.max(leftPath, rightPath);
    }

}
