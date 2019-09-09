package com.example.leedcode;

/**
 * @author Pengllrn
 * @since <pre>2019/6/12 9:28</pre>
 */
public class Q110 {
}

class Solution110 {
    public boolean isBalanced(TreeNode root) {
        if (root == null)
            return true;
        if (Math.abs(treeHeight(root.left) - treeHeight(root.right)) > 1)
            return false;
        else
            return isBalanced(root.left) && isBalanced(root.right);
    }

    private int treeHeight(TreeNode root) {
        if (root == null)
            return 0;
        return Math.max(treeHeight(root.left), treeHeight(root.right)) + 1;
    }
}

class Solution110_2 {
    private boolean result = true;
    public boolean isBalanced(TreeNode root) {
        maxDepth(root);
        return result;
    }

    private int maxDepth(TreeNode root) {
        if (root == null) return 0;
        int leftH = maxDepth(root.left);
        int rightH = maxDepth(root.right);
        if (Math.abs(leftH - rightH) > 1) result = false;
        return Math.max(leftH, rightH) + 1;
    }
}
