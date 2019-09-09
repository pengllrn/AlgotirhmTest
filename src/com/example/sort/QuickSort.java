package com.example.sort;

import java.util.Arrays;

/**
 * @author Pengllrn
 * @since <pre>2019/6/16 15:22</pre>
 */
public class QuickSort {
    public void sort(int[] nums) {
        if (nums == null || nums.length <= 1)
            return;
        quickSort(nums, 0, nums.length - 1);
    }

    private void quickSort(int[] nums, int left, int right) {
        if (left < right) {
            int partition = partition(nums, left, right);
            quickSort(nums, left, partition - 1);
            quickSort(nums, partition + 1, right);
        }
    }

    private int partition(int[] nums, int left, int right) {
        int pivot = nums[left];
        int i = left;
        int j = right + 1;
        while (true){
            while (i != right && nums[++i] <= pivot);
            while (j != left && nums[--j] >= pivot);
            if(i >= j)
                break;
            swap(nums,i,j);
        }
        swap(nums,left,j);
        return j;
    }

    private void swap(int[] nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();
        int[] in = new int[]{5,3,10,-3,1,2,439,23,1};
        quickSort.sort(in);
        System.out.println(Arrays.toString(in));
    }
}

