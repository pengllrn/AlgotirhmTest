package com.example.leedcode;

/**
 * @author Pengllrn
 * @since <pre>2019/6/12 9:17</pre>
 */
public class Q104 {
}

class Solution104 {
    private int maxDepth = 0;

    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        dfs(root, 0);
        return maxDepth;
    }

    private void dfs(TreeNode root, int len) {
        if (root == null) {
            maxDepth = Math.max(maxDepth, len);
            return;
        }
        dfs(root.left,len + 1);
        dfs(root.right,len + 1);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}