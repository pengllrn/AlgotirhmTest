package com.example.sort.P729;

import java.util.Arrays;

/**
 * @author Pengllrn
 * @since <pre>2019/7/29 15:07</pre>
 */
public class QuickSort{
    public void sort(int[] nums){
        if(nums == null || nums.length <= 1)
            return ;
        sortCore(nums, 0, nums.length - 1);
    }

    private void sortCore(int[] nums, int left, int right){
        if(right <= left)
            return ;
        int partition = partition(nums, left, right);
        sortCore(nums, left, partition - 1);
        sortCore(nums, partition + 1, right);
    }

    private int partition(int[] nums, int left, int right){
        int pivot = nums[left];
        int i = left;
        int j = right + 1;
        while(true){
            while(i < right && nums[++i] <= pivot);
            while(j > left && nums[--j] >= pivot);
            if(j <= i)
                break;
            swap(nums, i, j);
        }
        swap(nums, left, j);
        return j;
    }

    private void swap(int[] arr, int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();
        int[] in = new int[]{5,3,10,-3,1,2,439,23,1};
        quickSort.sort(in);
        System.out.println(Arrays.toString(in));
    }
}
