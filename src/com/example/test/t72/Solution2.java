package com.example.test.t72;


import java.util.Scanner;

public class Solution2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 0;t < T;t++){
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0;i < n;i++){
                arr[i] = sc.nextInt();
            }
            int ret = minNumberInRotateArray(arr);
            System.out.println(ret);
        }
    }

    private static int minNumberInRotateArray(int[] nums){
        if(nums == null || nums.length == 0)
            return 0;
        int left = 0;
        int right = nums.length - 1;
        if(nums[left] < nums[right])
            return nums[left];
        if(nums[left] == nums[right])
            return findOneByOne(nums);
        while (left < right - 1){
            int mid = left + (right - left) / 2;
            if(nums[mid] >= nums[left])
                left = mid;
            else
                right = mid;
        }
        return Math.min(nums[left],nums[right]);
    }

    private static int findOneByOne(int[] nums){
        int min = nums[0];
        for (int i = 1;i<nums.length;i++){
            min = Math.min(nums[i],min);
        }
        return min;
    }
}