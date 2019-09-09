package com.example.leedcode;

public class Q540 {
    public static void main(String[] args) {
        int i = new Solution540().singleNonDuplicate(new int[]{2,2,4,5,5,6,6,7,7});
        System.out.println(i);
    }
}

class Solution540 {

    public int singleNonDuplicate(int[] nums) {
        if (nums == null || nums.length == 0)
            throw new IllegalArgumentException("Illegal nums");
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid - 1] < nums[mid] && nums[mid + 1] > nums[mid])
                return nums[mid];
            boolean isOdd = ((right - left) >> 1 & 1) == 0;//中位数两边数的个数是不是偶的
            if(isOdd && nums[mid - 1] == nums[mid])
                right = mid - 2;
            else if(!isOdd && nums[mid] == nums[mid + 1])
                right = mid - 1;
            else if(isOdd && nums[mid] == nums[mid + 1])
                left = mid + 2;
            else
                left = mid + 1;
        }
        return nums[left];
    }

    public int singleNonDuplicate2(int[] nums) {
        int left = 0,right = nums.length - 1;
        while (left < right){
            int mid = left + (right - left) / 2;
            if((mid & 1) == 1)
                --mid;
            if(nums[mid] == nums[mid + 1])
                left = mid + 2;
            else
                right = mid;
        }
        return nums[left];
    }
}
