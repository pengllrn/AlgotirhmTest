package com.example.sort;

import java.util.Arrays;

/**
 * @author Pengllrn
 * @since <pre>2019/6/16 12:26</pre>
 */
public class MergeSort {
    private int[] aux;//辅助数组,用来存放原来的数据

    public void sort(int[] sourceArray) {
        if (sourceArray == null || sourceArray.length == 0)
            return;
        aux = new int[sourceArray.length];
        split(sourceArray, 0, sourceArray.length - 1);
    }

    private void split(int[] nums, int left, int right) {
        if (right <= left)
            return;
        int mid = left + (right - left) / 2;
        split(nums, left, mid);
        split(nums, mid + 1, right);
        merge(nums, left, mid, right);
    }

    /**
     * 将数组中两个已经排序的部分归并成一个
     * [left,mid]是第一个已经排好序的数组
     * [mid+1,right]是第二个已经排好序的数组
     */
    private void merge(int[] nums, int left, int mid, int right) {//原地合并，即修改nums
        for (int k = left; k <= right; k++) { // 将原数据复制到辅助数组，然后对原数组进行排序（每次只复制一段）
            aux[k] = nums[k];
        }
        int i = left;
        int j = mid + 1;//两个排序好的部分的起始点
        for (int k = left; k <= right; k++) {
            if (i > mid) {//左边部分已经全部放入到新的数组
                nums[k] = aux[j++];
            } else if (j > right) {//右边部分已经全部放入到新的数组
                nums[k] = aux[i++];
            } else if (aux[i] <= aux[j]) {//把小的数字先放入  // 先进行这一步，保证稳定性
                nums[k] = aux[i++];
            } else {
                nums[k] = aux[j++];
            }
        }
    }

    public static void main(String[] args) {
        int[] in = new int[]{5, 3, 10, -3, 2, 439, 23, 1};
        new MergeSort().sort(in);
        System.out.println(Arrays.toString(in));
    }
}
