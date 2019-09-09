package com.example.sort;

/**
 * @author Pengllrn
 * @since <pre>2019/6/16 10:47</pre>
 */
public class SelectionSort<T extends Comparable<T>> implements Sort<T>{
    @Override
    public void sort(T[] nums) {
        if(nums == null || nums.length <= 1)
            return;
        int n = nums.length;
        for (int i = 0;i<n;i++){
            int min = i;
            for (int j = i + 1;j<n;j++){
                if(nums[j].compareTo(nums[min]) < 0)
                    min = j;
            }
            swap(nums,i,min);
        }
    }
}
