package com.example.test;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Pengllrn
 * @since <pre>2019/8/24 9:56</pre>
 * <p>
 * 1,1,1,3,4,5,9,10 --> 3,4,10  1,1,1,5,9
 */
public class Solutionbk2 {
    private static int reach;
    private static int max;
    private static int min;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
            sum += nums[i];
        }
        Arrays.sort(nums);
        min = n;
        int size = sum / 2;
        int[] dp = new int[size + 1];
        for (int num : nums) {
            for (int j = size; j >= num; j--) {
                dp[j] = Math.max(dp[j], dp[j - num] + num);
                reach = Math.max(reach, dp[j]);
            }
        }
        System.out.print(sum - 2 * reach);
        for (int j = 0; j < n; j++) {
            if (j != 0 && nums[j] == nums[j - 1]) continue;
            backtrack(nums, j, nums[j], 1);
        }
        System.out.println(" " + Math.max(Math.abs(n - 2 * max), Math.abs(n - 2 * min)));
    }

    private static void backtrack(int[] nums, int idx, int sum, int cur) {
        if (sum >= reach) {
            if (sum == reach) {
                max = Math.max(max, cur);
                min = Math.min(min, cur);
            }
            return;
        }
        for (int i = idx + 1; i < nums.length; i++) {
            if (i != idx + 1 && nums[i] == nums[i - 1]) continue;
            backtrack(nums, i, sum + nums[i], cur + 1);
        }
    }
}
