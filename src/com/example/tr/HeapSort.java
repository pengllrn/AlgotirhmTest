package com.example.tr;

/**
 * @author Pengllrn
 * @since <pre>2019/6/29 12:09</pre>
 */
public class HeapSort {

    public void sort(int[] nums) {
        if (nums == null || nums.length == 0)
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
        int leftChild = 2 * i + 1;
        int rightChild = 2 * i + 2;
        int maxChild = i;
        if (leftChild < len && nums[leftChild] > nums[maxChild])
            maxChild = leftChild;
        if (rightChild < len && nums[rightChild] > nums[maxChild])
            maxChild = rightChild;
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
}
