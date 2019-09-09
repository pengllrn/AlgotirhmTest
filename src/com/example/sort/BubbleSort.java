package com.example.sort;

/**
 * @author Pengllrn
 * @since <pre>2019/6/16 10:59</pre>
 */
public class BubbleSort<T extends Comparable<T>> implements Sort<T> {
    @Override
    public void sort(T[] nums) {
        if (nums == null || nums.length <= 1)
            return;
        int n = nums.length;
        boolean isSorted = false;
        for (int i = n - 1; i > 0 && !isSorted; i--) {
            isSorted = true;
            for (int j = 0; j < i; j++) {
                if (nums[j].compareTo(nums[j + 1]) > 0) {
                    swap(nums, j, j + 1);
                    isSorted = false;
                }
            }
        }
    }
}
