package com.example.leedcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Pengllrn
 * @since <pre>2019/6/19 14:18</pre>
 */
public class Q501 {
}

class Solution501 {
    private int maxFeq = 0;
    private TreeNode preNode;
    private List<Integer> ans = new ArrayList<>();
    private int curFeq = 0;

    public int[] findMode(TreeNode root) {
        preNode = root;
        inOrder(root);
        int[] res = new int[ans.size()];
        for (int i = 0;i<ans.size();i++)
            res[i] = ans.get(i);
        return res;
    }

    private void inOrder(TreeNode root) {
        if (root == null)
            return;
        inOrder(root.left);
        curFeq = preNode.val == root.val ? curFeq + 1 : 1;
        if (curFeq > maxFeq) {
            maxFeq = curFeq;
            ans.clear();
            ans.add(root.val);
        } else if (curFeq == maxFeq)
            ans.add(root.val);
        preNode = root;
        inOrder(root.right);
    }

}
