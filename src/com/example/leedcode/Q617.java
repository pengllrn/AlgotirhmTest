package com.example.leedcode;

/**
 * @author Pengllrn
 * @since <pre>2019/6/12 10:54</pre>
 */
public class Q617 {
}

class Solution617 {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null || t2 == null)
            return t1 == null ? t2 : t1;
        TreeNode root = new TreeNode(t1.val + t2.val);
        root.left = mergeTrees(t1.left, t2.left);
        root.right = mergeTrees(t1.right, t2.right);
        return root;
    }
}
