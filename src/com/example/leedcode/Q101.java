package com.example.leedcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Pengllrn
 * @since <pre>2019/6/12 18:05</pre>
 */
public class Q101 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(9);
        root.left = new TreeNode(76);
        root.right = new TreeNode(76);
        root.left.left = new TreeNode(-4);
        root.right.right = new TreeNode(-4);
        root.left.left.left = new TreeNode(26);
        root.left.left.right = new TreeNode(-61);
        root.right.right.left = new TreeNode(-61);
        root.right.right.right = new TreeNode(-21);
        boolean symmetric = new Solution101_2().isSymmetric(root);
        System.out.println(symmetric);
    }
}

class Solution101 {
    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;
        return isSymmetric(root.left, root.right);
    }

    private boolean isSymmetric(TreeNode left, TreeNode right) {
        if (left == null || right == null)
            return left == right;
        if (left.val != right.val)
            return false;
        return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
    }
}

class Solution101_2 {
    public boolean isSymmetric(TreeNode root) {//递归
        if (root == null)
            return true;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root.left);
        queue.add(root.right);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0){
                TreeNode t1 = queue.poll();
                TreeNode t2 = queue.poll();
                size -= 2;
                if (t1 == null || t2 == null) {
                    if(t1 != t2)
                        return false;
                    if(queue.isEmpty())
                        return true;
                    else
                        continue;
                }
                if(t1.val != t2.val) return false;
                queue.add(t1.left);
                queue.add(t2.right);
                queue.add(t1.right);
                queue.add(t2.left);
            }
        }
        return true;
    }
}
