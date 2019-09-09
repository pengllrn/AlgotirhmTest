package com.example.leedcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * @author Pengllrn
 * @since <pre>2019/6/18 17:21</pre>
 */
public class Q145 {
}

class Solution145{//迭代
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root == null)
            return list;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode top = stack.pop();
            if (top == null)
                continue;
            list.add(top.val);
            stack.add(top.left);
            stack.push(top.right);
        }
        Collections.reverse(list);
        return list;
    }
}

class Solution145_2{//递归
    public List<Integer> postorderTraversal(TreeNode root){
        List<Integer> list = new ArrayList<>();
        postOder(root,list);
        return list;
    }

    private void postOder(TreeNode root,List<Integer> list){
        if(root == null)
            return;
        postOder(root.left,list);
        postOder(root.right,list);
        list.add(root.val);
    }
}