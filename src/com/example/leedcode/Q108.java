package com.example.leedcode;

/**
 * @author Pengllrn
 * @since <pre>2019/6/19 12:49</pre>
 */
public class Q108 {
}

class Solution108{
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums == null)
            return null;
        return build(nums,0,nums.length - 1);
    }

    private TreeNode build(int[] nums,int left,int right){
        if(left > right)
            return null;
        if(left == right)
            return new TreeNode(nums[left]);
        int mid = left + (right - left + 1) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = build(nums,left,mid-1);
        root.right = build(nums,mid+1,right);
        return root;
    }
}
