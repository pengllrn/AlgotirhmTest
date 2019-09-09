package com.example.sort.P729;

import java.util.Arrays;

/**
 * @author Pengllrn
 * @since <pre>2019/7/29 14:39</pre>
 */
public class HeapSort{
    public void sort(int[] nums){
        if(nums == null || nums.length <= 1)
            return ;
        buildHeap(nums);
        int len = nums.length - 1;
        for(int i = 0; i < nums.length; i++){
            swap(nums, 0, len);
            heapify(nums, 0, --len);
        }
    }

    private void buildHeap(int[] nums){//每一个节点的数都比子节点大，最大堆
        for(int i = nums.length / 2; i >= 0; i--){
            heapify(nums, i, nums.length - 1);
        }
    }

    private void heapify(int[] nums, int i, int len){
        int leftC = 2 * i + 1;
        int rightC = 2 * i + 2;
        int maxC = i;
        if(leftC <= len && nums[leftC] > nums[maxC])
            maxC = leftC;
        if(rightC <= len && nums[rightC] > nums[maxC])
            maxC = rightC;
        if(maxC != i){
            swap(nums, i, maxC);
            heapify(nums, maxC, len);
        }
    }

    private void swap(int[] arr, int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        HeapSort heapSort = new HeapSort();
        int[] in = new int[]{5, 3, 10, -3, 2, 439, 23, 1};
        heapSort.sort(in);
        System.out.println(Arrays.toString(in));
    }
}