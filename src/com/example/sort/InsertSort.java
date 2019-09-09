package com.example.sort;

/**
 * @author Pengllrn
 * @since <pre>2019/6/16 11:16</pre>
 */
public class InsertSort<T extends Comparable<T>> implements Sort<T> {
    @Override
    public void sort(T[] nums) {
        if (nums == null || nums.length <= 1)
            return;
        int n = nums.length;
        for (int i = 1; i < n; i++) {
            for (int j = i; j > 0 && nums[j - 1].compareTo(nums[j]) > 0; j--) {
                swap(nums, j, j - 1);
            }
        }
    }
}
