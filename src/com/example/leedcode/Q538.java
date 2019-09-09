package com.example.leedcode;

/**
 * @author Pengllrn
 * @since <pre>2019/6/19 9:55</pre>
 */
public class Q538 {
}

class Solution538{
    private int sum;
    public TreeNode convertBST(TreeNode root) {
        postOrder(root);
        return root;
    }

    private void postOrder(TreeNode root){
        if (root == null)
            return;
        postOrder(root.right);
        root.val += sum;
        sum = root.val;
        postOrder(root.left);
    }
}
