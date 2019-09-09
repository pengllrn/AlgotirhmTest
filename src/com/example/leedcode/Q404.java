package com.example.leedcode;

/**
 * @author Pengllrn
 * @since <pre>2019/6/13 11:20</pre>
 */
public class Q404 {
}

class Solution404{
    public int sumOfLeftLeaves(TreeNode root) {
        if(root == null)
            return 0;
        return sumOfLeftLeave(root.left) + sumOfRightLeave(root.right);
    }

    private int sumOfLeftLeave(TreeNode root){
        if(root == null)
            return 0;
        if(root.left == null && root.right == null){
            return root.val;
        }
        return sumOfLeftLeave(root.left) +sumOfRightLeave(root.right);
    }

    private int sumOfRightLeave(TreeNode root){
        if(root == null)
            return 0;
//        if(root.left == null && root.right == null){
//            return 0;
//        }
        return sumOfLeftLeave(root.left) + sumOfRightLeave(root.right);
    }
}

class Solution404_2{
    public int sumOfLeftLeaves(TreeNode root){
        if(root == null)
            return 0;
        if(isLeftLeave(root.left)) return root.left.val + sumOfLeftLeaves(root.right);
        return sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);

    }
    private boolean isLeftLeave(TreeNode root){
        if(root == null)
            return false;
        return root.left == null && root.right == null;
    }
}
