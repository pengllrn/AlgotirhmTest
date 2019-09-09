package com.example.leedcode;

import java.util.Arrays;

public class Q34 {
    public static void main(String[] args) {
        int[] ints = new Solution34().searchRange(new int[]{1}, 8);
        System.out.println(Arrays.toString(ints));
    }
}


/**
 * 有序数组，没有说是从小到大还是从大到小
 */
class Solution34 {

    public int[] searchRange(int[] nums, int target) {
        int start = -1, end = -1;
        if (nums == null || nums.length == 0)
            return new int[]{start, end};
        int temp = findFirst(nums, target);
        start = temp < nums.length && nums[temp] == target ? temp : -1;
        end = start != -1 ? findFirst(nums, target + 1) - 1 : -1;
        return new int[]{start, end};
    }

    private int findFirst(int[] nums, int target) {
        int left = 0, right = nums.length;
        while (left < right) {
            int mid = left + (right - 1);
            if (nums[mid] >= target)
                right = mid;
            else
                left = mid + 1;
        }
        return right;
    }
}
