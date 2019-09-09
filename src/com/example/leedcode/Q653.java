package com.example.leedcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Pengllrn
 * @since <pre>2019/6/19 13:57</pre>
 */
public class Q653 {
}

class Solution653{
    public boolean findTarget(TreeNode root, int k) {
        if (root == null)
            return false;
        List<Integer> list = new ArrayList<>();
        inorder(root,list);
        int l = 0, h = list.size() - 1;
        while (l < h){
            int sum = list.get(l) + list.get(h);
            if(sum == k)
                return true;
            else if(sum < k)
                l++;
            else
                h--;
        }
        return false;
    }

    private void inorder(TreeNode root,List<Integer> list){
        if(root == null)
            return;
        inorder(root.left,list);
        list.add(root.val);
        inorder(root.right,list);
    }


}
