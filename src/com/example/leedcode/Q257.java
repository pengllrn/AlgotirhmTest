package com.example.leedcode;

import java.util.ArrayList;
import java.util.List;

public class Q257 {

}

class Solution257 {

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans = new ArrayList<>();
        if (root == null)
            return ans;
        backtracking(ans, root, new StringBuilder());
        return ans;
    }

    private void backtracking(List<String> ans, TreeNode node, StringBuilder temp) {
        String part = String.valueOf(node.val);
        if (temp.length() != 0)
            part = "->" + part;
        temp.append(part);
        if (node.left == null && node.right == null) {//递归终止
            ans.add(temp.toString());
        }
        if (node.left != null)
            backtracking(ans, node.left, temp);
        if (node.right != null)
            backtracking(ans, node.right, temp);
        temp.delete(temp.length() - part.length(), temp.length());
    }


    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
