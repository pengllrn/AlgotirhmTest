package com.example.tr;

import java.util.Scanner;

/**
 * @author Pengllrn
 * @since <pre>2019/6/29 12:18</pre>
 */
public class MergeSort {
    private int[] aux;
    public void sort(int[] nums){
        if(nums == null || nums.length == 0)
            return;
        sortCore(nums,0,nums.length - 1);


    }

    private void sortCore(int[] nums,int left,int right){
        if(right <= left)
            return;
        int mid = left + (right - left) / 2;
        sortCore(nums,left,mid);
        sortCore(nums,mid + 1,right);
        merge(nums,left,mid,right);
    }

    private void merge(int[] nums, int left,int mid, int right) {
        for (int i = left;i<=right;i++)
            aux[i] = nums[i];
        while (true){

        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
    }
}
