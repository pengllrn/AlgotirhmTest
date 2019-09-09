package com.example.test;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Pengllrn
 * @since <pre>2019/8/24 11:24</pre>
 */
public class Solutionbk3 {
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
        int size = sum / 2;
        int reach = 0;
        int[] dp = new int[size + 1];
        int[] minDp = new int[size + 1];//能凑到i 最少个数，例如[1，2，3]，能凑到3的最少个数为1个
        int[] maxDp = new int[size + 1];//能凑到i 最多个数，例如[1，2，3]，能凑到3的最多个数为2个
        for (int num : nums) {
            for (int j = size; j >= num; j--) {
                dp[j] = Math.max(dp[j], dp[j - num] + num);//0-1背包
                reach = Math.max(reach, dp[j]);

                if (j == num) minDp[j] = 1;

                else if (minDp[j - num] != 0 && minDp[j] != 0)
                    minDp[j] = Math.min(minDp[j], minDp[j - num] + 1);
                else if (minDp[j - num] != 0) minDp[j] = minDp[j - num] + 1;

                if (j == num) maxDp[j] = 1;
                else if (maxDp[j - num] != 0) maxDp[j] = Math.max(maxDp[j], maxDp[j - num] + 1);
            }
        }
        System.out.print(sum - 2 * reach);
        System.out.println(" " + Math.max(Math.abs(n - 2 * maxDp[reach]), Math.abs(n - 2 * minDp[reach])));
    }
}
