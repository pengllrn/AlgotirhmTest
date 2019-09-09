package com.example.leedcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Pengllrn
 * @since <pre>2019/6/19 9:31</pre>
 */
public class Q230 {
}

class Solution230 {
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        inorder(root, list);
        return list.get(k - 1);
    }

    private void inorder(TreeNode root, List<Integer> list) {
        if (root == null)
            return;
        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }
}
