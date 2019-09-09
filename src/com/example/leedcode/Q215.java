package com.example.leedcode;

public class Q215 {
    public static void main(String[] args) {
        int kthLargest = new KthLargest().findKthLargest(new int[]{3,2,3,1,2,4,5,5,6}, 4);
        System.out.println(kthLargest);
    }
}

class KthLargest {

    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k > nums.length)
            return 0;
        k = nums.length - k;
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int partition = partition(nums, left, right);
            if (partition == k)
                break;
            if (partition < k)
                left = partition + 1;
            else
                right = partition - 1;
        }
        return nums[k];
    }

    private int partition(int[] nums, int left, int right) {
        int pivot = nums[left];
        int i = left;
        int j = right + 1;
        while (true) {
            while (nums[++i] < pivot && i < right) ;
            while (nums[--j] > pivot && j > left) ;
            if (i >= j)
                break;
            swap(nums, i, j);
        }
        swap(nums, left, j);
        return j;
    }

    private void swap(int[] nums, int i, int j) {
//        nums[i] = nums[i] ^ nums[j];
//        nums[j] = nums[i] ^ nums[j];
//        nums[i] = nums[i] ^ nums[j];
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}