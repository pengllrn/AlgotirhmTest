package com.example.leedcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Pengllrn
 * @since <pre>2019/6/18 16:41</pre>
 */
public class Q637 {
}

class Solution637{
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> list = new LinkedList<>();
        if(root == null)
            return list;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            double temp = size;
            double sum = 0;
            while (size-- > 0){
                TreeNode node = queue.remove();
                sum += node.val;
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
            }
            list.add(sum / temp);
        }
        return list;
    }
}
