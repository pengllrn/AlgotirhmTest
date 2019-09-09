package com.example.leedcode;

public class Q213 {
    public static void main(String[] args) {
        int rob = new Rober2().rob(new int[]{2, 3, 9});
        System.out.println(rob);
    }
}

class Rober2{

    public int rob(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;
        int n = nums.length;
        if(n==1)
            return nums[0];
        if(n==2)
            return Math.max(nums[0],nums[1]);
        return Math.max(rob(nums,0,n-1),rob(nums,1,n));
    }

    private int rob(int[] nums,int start,int end){
        int pre2 = 0,pre1 = 0;
        for (int i = start;i<end;i++){
            int cur = Math.max(pre1,pre2 + nums[i]);
            pre2 = pre1;
            pre1 = cur;
        }
        return pre1;
    }
}
