package com.example.leedcode;

import java.util.ArrayList;
import java.util.List;

public class Q95 {
    public static void main(String[] args) {
        List<Solution95.TreeNode> treeNodes = new Solution95().generateTrees(3);
        System.out.println(treeNodes);
    }
}

class Solution95 {

    public List<TreeNode> generateTrees(int n) {

        List<TreeNode> list = new ArrayList<>();
        if(n < 1)
            return list;
        list = generateCore(1,n);
        return list;
    }

    private List<TreeNode> generateCore(int left, int right) {
        List<TreeNode> temp = new ArrayList<>();
        if (left > right)
            temp.add(null);
        for (int i = left; i <= right; i++) {
            List<TreeNode> nodesLeft = generateCore(left, i - 1);
            List<TreeNode> nodesRight = generateCore(i + 1, right);
            for (TreeNode nodeL : nodesLeft) {
                for (TreeNode nodeR : nodesRight) {
                    TreeNode node = new TreeNode(i);
                    node.left = nodeL;
                    node.right = nodeR;
                    temp.add(node);
                }
            }
        }
        return temp;
    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}

