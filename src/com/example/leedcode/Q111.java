package com.example.leedcode;

/**
 * @author Pengllrn
 * @since <pre>2019/6/13 10:02</pre>
 */
public class Q111 {
}

class Solution111{
    public int minDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }

        if(root.left == null || root.right == null) {
            if(root.left == null && root.right == null)
                return 1;
            //return root.left == null ? minDepth(root.right) + 1 : minDepth(root.left) + 1;
            return Math.max(minDepth(root.left),minDepth(root.right));
        }
        return Math.min(minDepth(root.left),minDepth(root.right)) + 1;
    }
}
