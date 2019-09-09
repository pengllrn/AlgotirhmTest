package com.example.test.t72;

/**
 * @author Pengllrn
 * @since <pre>2019/7/2 20:47</pre>
 */
public class Solution3 {
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        if(root1 == null || root2 == null)
            return false;
        if(root1.val == root2.val){
            if(isSame(root1.left, root2.left) && isSame(root1.right, root2.right))
                return true;
        }
        return HasSubtree(root1.left, root2) || HasSubtree(root1.right, root2);
    }

    private boolean isSame(TreeNode root1,TreeNode root2){
        if(root1 == null || root2 == null){
            return root1 == root2;
        }
        if(root1.val != root2.val)
            return false;
        return isSame(root1.left,root2.left) && isSame(root1.right,root2.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        boolean ret = new Solution3().HasSubtree(root,root.right);
        System.out.println(ret);
    }


}

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val){
        this.val = val;
    }
}
