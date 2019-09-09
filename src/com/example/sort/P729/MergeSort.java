package com.example.sort.P729;

import java.util.Arrays;

/**
 * @author Pengllrn
 * @since <pre>2019/7/29 15:11</pre>
 */
public class MergeSort{
    private int[] aux;
    public void sort(int[] nums){
        if(nums == null || nums.length <= 1)
            return ;
        aux = new int[nums.length];
        sortCore(nums, 0, nums.length - 1);
    }

    private void sortCore(int[] nums, int left, int right){
        if(left >= right)
            return;
        int mid = left + (right - left) / 2;
        sortCore(nums, left, mid);
        sortCore(nums, mid + 1, right);
        merge(nums, left, mid, right);
    }

    private void merge(int[] nums, int left, int mid, int right){
        for (int i = left; i <= right; i++) {
            aux[i] = nums[i];
        }
        int i = left;
        int j = mid + 1;
        for (int k = left; k <= right; k++) {
            if(i > mid){
                nums[k] = aux[j++];
            }else if(j > right){
                nums[k] = aux[i++];
            }else if(aux[i] <= aux[j]){
                nums[k] = aux[i++];
            }else
                nums[k] = aux[j++];
        }
    }

    public static void main(String[] args) {
        int[] in = new int[]{5, 3, 10, -3, 2, 439, 23, 1};
        new MergeSort().sort(in);
        System.out.println(Arrays.toString(in));
    }
}