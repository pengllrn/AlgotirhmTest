package com.example.leedcode;

/**
 * @author Pengllrn
 * @since <pre>2019/6/12 10:45</pre>
 */
public class Q226 {
}

class Solution226{

    public TreeNode invertTree(TreeNode root) {
        if(root == null)
            return null;
        TreeNode temp  = root.left;
        root.left = root.right;
        root.right = temp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }


}
