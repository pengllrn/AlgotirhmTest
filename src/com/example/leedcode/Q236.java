package com.example.leedcode;

/**
 * @author Pengllrn
 * @since <pre>2019/6/19 10:53</pre>
 */
public class Q236 {
}

class Solution236 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null || right != null) {
            if (left != null && right != null)
                return root;
            return left != null ? left : right;
        }
        return null;
    }
}
