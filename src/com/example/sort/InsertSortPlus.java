package com.example.sort;

import java.util.Arrays;

/**
 * @author Pengllrn
 * @since <pre>2019/6/16 11:39</pre>
 */
public class InsertSortPlus {
    public void sort(int[] nums) {
        if (nums == null || nums.length <= 1)
            return;
        int n = nums.length;
        for (int i = 1; i < n; i++) {
            if(nums[i] >= nums[i-1])
                continue;
            int ex = binarySearch(nums, i, nums[i]);
            while (ex != i) {
                swap(nums, ex, i);
                ex = binarySearch(nums, i, nums[i]);
            }
        }
    }

    /**
     * 在0-len内找到第一个大于等于key的数的坐标
     * @param nums
     * @param len
     * @param key
     * @return
     */
    private int binarySearch(int[] nums, int len, int key) {
        int left = 0;
        int right = len;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (key >= nums[mid])
                left = mid + 1;
            else
                right = mid;
        }
        return left;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] in = new int[]{1,1,3,2,1,2,2,3,3};
        new InsertSortPlus2().sort(in);
        System.out.println(Arrays.toString(in));
    }
}

class InsertSortPlus2{
    public void sort(int[] nums){
        if(nums == null || nums.length <= 1)
            return;
        for (int i = 1; i < nums.length; i++) {
            if(nums[i] >= nums[i - 1])
                continue;
            int ex = binarySearch(nums, i, nums[i]);
            while(ex != i){
                swap(nums, ex, i);
                ex = binarySearch(nums, i, nums[i]);
            }
        }
    }

    private int binarySearch(int[] nums,int len, int val){
        int left = 0;
        int right = len;
        while(left < right){
            int mid = left + (right - left) / 2;
            if(val >= nums[mid])
                left = mid + 1;
            else
                right = mid;
        }
        return left;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
