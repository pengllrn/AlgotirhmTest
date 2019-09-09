package com.example.leedcode;

public class Q88 {

}

/**
 * 88. 合并两个有序数组
 * 给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
 */
class MergeTwoArray{

    /**
     * @param nums1
     * @param m nums1中元素的个数
     * @param nums2
     * @param n nums2中元素的个数
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if(nums2 == null || nums2.length == 0)
            return;
        int len = m + n - 1;
        while (m >=0 && n>=0){
            if(nums1[m-1] > nums2[n-1]) {
                nums1[len--] = nums1[m - 1];
                m--;
            }
            else {
                nums1[len--] = nums2[n - 1];
                n--;
            }
        }
        if(m<0){
            for (int i = 0;i<n;i++)
                nums1[i]=nums2[i];
        }
    }
}
