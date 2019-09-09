package com.example.leedcode;

/**
 * @author Pengllrn
 * @since <pre>2019/6/19 10:33</pre>
 */
public class Q235 {
}

class Solution235 {
    private int min;
    private int max;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == null || q == null)
            return null;
        min = Math.min(p.val, q.val);
        max = Math.max(p.val, q.val);
        return findLowest(root);
    }

    private TreeNode findLowest(TreeNode root) {
        if (root == null)
            return null;
        if (root.val < min)
            return findLowest(root.right);
        if (root.val > max)
            return findLowest(root.left);
        return root;
    }
}
