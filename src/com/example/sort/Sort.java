package com.example.sort;

/**
 * @author Pengllrn
 * @since <pre>2019/6/16 10:49</pre>
 */
public interface Sort<T> {
    void sort(T[] nums);
    default void swap(T[] nums,int i,int j){
        T temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
