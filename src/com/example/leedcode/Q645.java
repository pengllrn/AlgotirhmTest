package com.example.leedcode;

import java.util.Arrays;

/**
 * @author Pengllrn
 * @since <pre>2019/6/23 9:49</pre>
 */
public class Q645 {
    public static void main(String[] args) {
        int[] errorNums = new Solution645_2().findErrorNums(new int[]{8,7,3,5,3,6,1,4});
        System.out.println(Arrays.toString(errorNums));
    }
}

class Solution645 {//交换排序
    public int[] findErrorNums(int[] nums) {
        if (nums == null || nums.length == 0)
            return null;
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != i + 1 && nums[i] != nums[nums[i] - 1]) {//1,3,3,4,5,6,7,8
                swap(nums, i, nums[i] - 1);
            }
        }
        for (int i = 0;i< nums.length;i++){
            if(nums[i] != i + 1){
                return new int[]{nums[i],i + 1};
            }
        }
        return null;
    }

    private void swap(int[] nums, int i, int j) {
        int q = nums[i];
        nums[i] = nums[j];
        nums[j] = q;
    }
}

class Solution645_2{//哈希表
    public int[] findErrorNums(int[] nums) {//[8,7,3,5,3,6,1,4]  [1,0,2,1,1,1,1,1]
        boolean[] hash = new boolean[nums.length];
        int[] ans = new int[2];
        for (int i = 0;i<nums.length;i++){
            if(hash[nums[i] - 1]){
                ans[0] = nums[i];
            }
            hash[nums[i] - 1] = true;
        }
        for (int i = 0;i<nums.length;i++){
            if(!hash[i]){
                ans[1] = i + 1;
                return ans;
            }
        }
        return null;
    }
}
