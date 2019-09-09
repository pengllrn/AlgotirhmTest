package com.example.leedcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Pengllrn
 * @since <pre>2019/6/18 17:00</pre>
 */
public class Q513 {
}

class Solution513 {
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int layerFirst = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            TreeNode first = queue.peek();
            layerFirst = first.val;
            while (size-- >0){
                TreeNode node = queue.remove();
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
            }
        }
        return layerFirst;
    }
}
