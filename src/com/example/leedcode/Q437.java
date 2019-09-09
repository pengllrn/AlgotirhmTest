package com.example.leedcode;

/**
 * @author Pengllrn
 * @since <pre>2019/6/12 13:12</pre>
 */
public class Q437 {//双重递归
}

class Solution437 {
    public int pathSum(TreeNode root, int sum) {
        if (root == null)
            return 0;
        return backtrack(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }

    private int backtrack(TreeNode root, int target) {
        if (root == null)
            return 0;
        int ret = 0;
        if (root.val == target)
            ret++;
        ret += backtrack(root.left, target - root.val) + backtrack(root.right, target - root.val);
        return ret;
    }

}

class Solution437_2{

    private int ans = 0;
    public int pathSum(TreeNode root, int sum) {
        if(root == null)
            return 0;
        backtrack(root,sum);
        pathSum(root.left,sum);
        pathSum(root.right,sum);
        return ans;
    }

    private void backtrack(TreeNode root,int target){
        if(root == null)
            return;
        if(target == root.val)
            ans++;
        backtrack(root.left,target - root.val);
        backtrack(root.right,target - root.val);
    }
}