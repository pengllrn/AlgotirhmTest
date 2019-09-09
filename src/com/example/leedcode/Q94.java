package com.example.leedcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author Pengllrn
 * @since <pre>2019/6/18 21:30</pre>
 */
public class Q94 {//中序遍历
}

class Solution94 {//迭代

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null)
            return list;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {//左
                stack.push(cur);
                cur = cur.left;
            }
            TreeNode pop = stack.pop();
            list.add(pop.val);//中
            cur = pop.right;//右
        }
        return list;
    }
}

class Solution94_2 {//递归
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inorder(root, list);
        return list;
    }

    private void inorder(TreeNode root, List<Integer> list) {
        if (root == null)
            return;
        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }
}