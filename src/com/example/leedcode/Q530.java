package com.example.leedcode;

/**
 * @author Pengllrn
 * @since <pre>2019/6/19 14:09</pre>
 */
public class Q530 {
}

class Solution530{
    TreeNode preNode = null;
    private int maxDiff = Integer.MAX_VALUE;
    public int getMinimumDifference(TreeNode root) {
        inorder(root);
        return maxDiff;
    }

    private void inorder(TreeNode root){
        if(root == null)
            return;
        inorder(root.left);
        maxDiff = preNode != null ? Math.min(maxDiff,Math.abs(root.val - preNode.val)) : maxDiff;
        preNode = root;
        inorder(root.right);
    }
}
