package com.example.leedcode;

/**
 * @author Pengllrn
 * @since <pre>2019/6/19 9:14</pre>
 */
public class Q669 {
}

class Solution669{
    public TreeNode trimBST(TreeNode root, int L, int R) {
        if (root == null)
            return null;
        if(root.val < L)
            return trimBST(root.right,L,R);
        if(root.val > R)
            return trimBST(root.left,L,R);
        root.left = trimBST(root.left,L,R);
        root.right = trimBST(root.right,L,R);

        return root;
    }

}
