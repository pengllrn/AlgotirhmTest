package com.example.leedcode;

public class Q53 {
    public static void main(String[] args) {
        int i = new MaxSum().maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4});
        System.out.println(i);
    }
}

class MaxSum{

    public int maxSubArray(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;
        int res = nums[0];
        int sum = 0;
        for (int i = 0;i< nums.length;i++){
            if(sum > 0)
                sum += nums[i];
            else {
                sum = nums[i];
            }
            res = Math.max(sum,res);
        }
        return res;
    }
}
