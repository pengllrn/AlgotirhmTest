package com.example.leedcode;

public class Q153 {
    public static void main(String[] args) {
        int min = new Solution153().findMin(new int[]{11});
        System.out.println(min);
    }
}

/**
 * 有相同的元素考不考虑
 */
class Solution153 {

    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0)
            return -1;
        int left = 0, right = nums.length - 1;
        while (left < right) {
            if (nums[left] <= nums[right])
                return nums[left];
            int mid = left + (right - left) / 2;
            if (nums[mid] >= nums[left])
                left = mid + 1;
            else
                right = mid;
        }
        return nums[left];
    }
}