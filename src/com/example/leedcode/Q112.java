package com.example.leedcode;

/**
 * @author Pengllrn
 * @since <pre>2019/6/12 11:01</pre>
 */
public class Q112 {
}

class Solution112{
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;
        if (root.left == null && root.right == null && root.val == sum) return true;
        return hasPathSum(root.left,sum - root.val) || hasPathSum(root.right,sum - root.val);
    }
}
