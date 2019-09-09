package com.example.leedcode;

/**
 * @author Pengllrn
 * @since <pre>2019/6/12 10:32</pre>
 */
public class Q543 {
}

class Solution543{
    private int diameter = 0;
    public int diameterOfBinaryTree(TreeNode root){
        maxDepth(root);
        return diameter;
    }

    private int maxDepth(TreeNode root){
        if(root == null)
            return 0;
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        diameter = Math.max(diameter,left + right);
        return Math.max(left,right) + 1;
    }
}
