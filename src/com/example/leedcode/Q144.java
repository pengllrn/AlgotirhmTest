package com.example.leedcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author Pengllrn
 * @since <pre>2019/6/18 17:10</pre>
 */
public class Q144 {
}


class Solution144 {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null)
            return list;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            list.add(node.val);
            if(node.right != null) stack.push(node.right);
            if(node.left != null) stack.push(node.left);
        }
        return list;
    }
}