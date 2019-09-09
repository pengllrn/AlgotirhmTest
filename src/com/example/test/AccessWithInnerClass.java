package com.example.test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * @author Pengllrn
 * @since <pre>2019/7/7 10:27</pre>
 */
public class AccessWithInnerClass {

    private String serialize;
    String Serialize(TreeNode root) {
        if(root == null)
            return "#";
        return root.val + " " + Serialize(root.left) + " " + Serialize(root.right);
    }

    TreeNode Deserialize(String str) {
        if(str == null) return null;
        this.serialize = str;
        return Deserialize();
    }

    private TreeNode Deserialize(){
        if(serialize.length() == 0)
            return null;
        int idx = serialize.indexOf(" ");
        String val = idx == -1 ? serialize : serialize.substring(0, idx);
        serialize = idx == -1 ? "" : serialize.substring(idx + 1);
        if("#".equals(val)) return null;
        TreeNode node = new TreeNode(Integer.valueOf(val));
        node.left = Deserialize();
        node.right =Deserialize();
        return node;
    }

    public static void main(String[] args) {
        String serialize = new AccessWithInnerClass().Serialize(new TreeNode(4));
        System.out.println(serialize);
        TreeNode deserialize = new AccessWithInnerClass().Deserialize(serialize);
        System.out.println();
        PriorityQueue<Integer> queue = new PriorityQueue<>();
    }
}

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}