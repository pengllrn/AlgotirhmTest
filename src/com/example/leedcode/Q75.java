package com.example.leedcode;

import java.util.Arrays;

public class Q75 {
    public static void main(String[] args) {
        int[] nums = new int[]{2,1,2,2,2,1,1};
        new Color().sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }
}

/**
 * 颜色分类
 */
class Color{

    public void sortColors(int[] nums) {
        if(nums == null || nums.length == 0 || nums.length == 1)
            return;
        int p0 = 0;
        int p2 = nums.length - 1;
        int i = 0;
        while (i<=p2){
            if(nums[i] == 0) {
                swap(nums,i,p0);
                p0++;
                i++;
            }
            else if(nums[i] == 1) {
                i++;
            }
            else if(nums[i] == 2) {
                swap(nums, i, p2);
                p2--;
            }
        }
    }

    private void swap(int[] nums,int i,int j){
        if(i == j)
            return;
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
