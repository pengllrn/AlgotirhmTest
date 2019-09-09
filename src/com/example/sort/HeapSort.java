package com.example.sort;

import java.util.Arrays;

/**
 * @author Pengllrn
 * @since <pre>2019/6/16 16:00</pre>
 */
public class HeapSort {
    public void sort(int[] nums) {
        if (nums == null || nums.length <= 1)
            return;
        buildHeap(nums);
        int len = nums.length;
        for (int i = 0; i < nums.length; i++) {
            swap(nums, 0, --len);
            heapify(nums, 0, len);
        }
    }

    private void buildHeap(int[] nums) {
        for (int i = nums.length / 2; i >= 0; i--) {
            heapify(nums, i, nums.length);
        }
    }

    private void heapify(int[] nums, int i, int len) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int maxChild = i;
        if (left < len && nums[maxChild] < nums[left])
            maxChild = left;
        if (right < len && nums[maxChild] < nums[right])
            maxChild = right;
        if (maxChild != i) {
            swap(nums, maxChild, i);
            heapify(nums, maxChild, len);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        HeapSort heapSort = new HeapSort();
        int[] in = new int[]{5, 3, 10, -3, 2, 439, 23, 1};
        heapSort.sort(in);
        System.out.println(Arrays.toString(in));
    }
}

