package com.example.leedcode;

/**
 * @author Pengllrn
 * @since <pre>2019/6/18 15:52</pre>
 */
public class Q337 {
}

class Solution337{
    public int rob(TreeNode root) {
        if(root == null)
            return 0;
        int include = root.val;
        if(root.left != null) include += rob(root.left.left) + rob(root.left.right);
        if(root.right != null) include += rob(root.right.left) + rob(root.right.right);
        return Math.max(include, rob(root.left) + rob(root.right));
    }
}
