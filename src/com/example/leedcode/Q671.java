package com.example.leedcode;

/**
 * @author Pengllrn
 * @since <pre>2019/6/18 16:22</pre>
 */
public class Q671 {
}

class Solution671{
    public int findSecondMinimumValue(TreeNode root) {
        if(root == null)
            return -1;
        int leftMin = root.left != null && root.left.val != root.val? root.left.val : findSecondMinimumValue(root.left);
        int rightMin = root.right != null && root.right.val != root.val ? root.right.val : findSecondMinimumValue(root.right);
        if(leftMin == -1) return rightMin;
        if(rightMin == -1) return leftMin;
        return Math.min(leftMin,rightMin);
    }
}
