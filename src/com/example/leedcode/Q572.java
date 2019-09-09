package com.example.leedcode;

/**
 * @author Pengllrn
 * @since <pre>2019/6/12 17:37</pre>
 */
public class Q572 {
    public static void main(String[] args) {
        TreeNode t = new TreeNode(3);
        t.left = new TreeNode(1);
        t.right = new TreeNode(2);
        TreeNode s = new TreeNode(3);
        s.left = new TreeNode(4);
        s.right = new TreeNode(5);
        s.left.left = new TreeNode(1);
        s.right.left = new TreeNode(2);
        boolean subtree = new Solution572().isSubtree(s, t);
        System.out.println(subtree);
    }
}

class Solution572 {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null || t == null) {
            return s == null && t == null;
        }
        if (s.val == t.val) {
            if (isSame(s, t))
                return true;
        }
        return isSubtree(s.left, t) || isSubtree(s.right, t);
    }

    private boolean isSame(TreeNode s, TreeNode t) {
        if (s == null || t == null) {
            return s == null && t == null;
        }
        if (s.val != t.val)
            return false;
        return isSame(s.left, t.left) && isSame(s.right, t.right);
    }
}
