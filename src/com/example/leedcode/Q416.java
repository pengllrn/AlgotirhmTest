package com.example.leedcode;

import java.util.Arrays;

/**
 * @author Pengllrn
 * @since <pre>2019/6/8 22:33</pre>
 */
public class Q416 {
    public static void main(String[] args) {
        boolean b = new Solution416_3().canPartition(new int[]{1,2});
        System.out.println(b);
    }
}

class Solution416 {//动态规划1

    public boolean canPartition(int[] nums) {
        if (nums == null || nums.length == 0)
            return false;
        int sum = 0;
        for (int num : nums)
            sum += num;
        if ((sum & 1) == 1)
            return false;
        int[][] dp = new int[nums.length + 1][(sum >> 1) + 1];
        for (int i = 1; i <= nums.length; i++) {
            int w = nums[i - 1];
            int v = nums[i - 1];
            for (int j = 1; j <= (sum >> 1); j++) {
                if (w <= j) {
                    dp[i][j] = Math.max(dp[i - 1][j - w] + v, dp[i - 1][j]);
                } else
                    dp[i][j] = dp[i - 1][j];
            }
        }
        return dp[nums.length][sum >> 1] == sum >> 1;
    }
}

class Solution416_2 {//动态规划：压缩空间

    public boolean canPartition(int[] nums) {
        if (nums == null || nums.length == 0)
            return false;
        int sum = 0;
        for (int num : nums)
            sum += num;
        if ((sum & 1) == 1)
            return false;
        int[] dp = new int[(sum >> 1) + 1];//容量为1到sum/2容量的背包，分别所能放的价值
        for (int i = 0; i < nums.length; i++) {
            int w = nums[i], v = nums[i];
            for (int j = sum >> 1; j > 0; j--)
                if (w <= j) {
                    dp[j] = Math.max(dp[j], dp[j - w] + v);
                }
        }
        return dp[sum >> 1] == sum >> 1;
    }

    public boolean canPartion(int[] nums) {
        if (nums == null || nums.length == 0)
            return false;
        int sum = 0;
        for (int num : nums)
            sum += num;
        if ((sum & 1) == 1)
            return false;
        int size = sum >> 1;
        boolean[] dp = new boolean[size + 1];
        dp[0] = true;
        for (int num : nums) {
            for (int j = size; j > 0; j--) {
                if (num <= j)
                    dp[j] = dp[j] || dp[j - num];
            }
        }
        return dp[size];
    }
}

class Solution416_3 {//回溯

    public boolean canPartition(int[] nums) {
        if (nums == null || nums.length == 0)
            return false;
        Arrays.sort(nums);
        int sum = 0;
        for (int num : nums)
            sum += num;
        if ((sum & 1) == 1)
            return false;
        int size = sum >> 1;
        return backtrack(nums, size, nums.length - 1);
    }

    private boolean backtrack(int[] nums, int size, int end) {
        for (int j = end; j > 0 && nums[j] <= size; j--) {
            if (nums[j] == size)
                return true;
            if (backtrack(nums, size - nums[j], j - 1) || backtrack(nums, size, j - 1))
                return true;
        }
        return false;
    }
}
