package com.example.sort;

import java.util.Arrays;

/**
 * @author Pengllrn
 * @since <pre>2019/6/16 12:04</pre>
 */
public class ShellSort {
    public void sort(int[] nums) {
        if (nums == null || nums.length <= 1)
            return;
        int n = nums.length;
        int h = 1;
        while (h < n / 3)
            h = 3 * h + 1;//1，4，13
        while (h >= 1) {
            for (int i = h; i < n; i++) {
                for (int j = i;j >=h && nums[j] < nums[j - h];j -= h){
                    swap(nums,j,j - h);
                }
            }
            h /= 3;
        }
    }

    private void swap(int[] nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] in = new int[]{5,3,10,-3,2,439,23,1};
        new ShellSort().sort(in);
        System.out.println(Arrays.toString(in));;
    }
}
