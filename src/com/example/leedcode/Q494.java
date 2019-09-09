package com.example.leedcode;

/**
 * @author Pengllrn
 * @since <pre>2019/6/9 9:34</pre>
 */
public class Q494 {
    public static void main(String[] args) {
        int targetSumWays = new Solution494_2().findTargetSumWays(new int[]{0,0,0,0,0,0,0,0,1}, 1);
        System.out.println(targetSumWays);
    }
}

class Solution494 {//回溯算法

    public int findTargetSumWays(int[] nums, int S) {
        if (nums == null)
            return 0;
        return backtrack(nums, S, 0);
    }

    /**
     * @param S
     * @param i 起始位置
     */
    private int backtrack(int[] nums, int S, int i) {
        if (i == nums.length) {
            return S == 0 ? 1 : 0;
        }
        return backtrack(nums, S + nums[i], i + 1) + backtrack(nums, S - nums[i], i + 1);
    }
}

/**
 * 动态规划
 * sum(P) - sum(N) = target
 * sum(P) + sum(N) + sum(P) - sum(N) = target + sum(P) + sum(N)
 * 2*sum(P) = target + sum(nums)
 * sum(P) = (target + sum(nums))/2
 *
 *
 * [0,0,0,0,0,0,0,0,1]
 * 1
 */
class Solution494_2 {//动态规划

    public int findTargetSumWays(int[] nums, int S) {
        if (nums == null)
            return 0;
        int sum = 0;
        for (int num : nums)
            sum += num;
        if(sum < S || ((sum + S) & 1) == 1)
            return 0;
        int W = (S + sum) >> 1;
        int[] dp = new int[W + 1];//容量为i的背包中可以出现多少种组合
        dp[0] = 1;
        for (int num : nums) {
            for (int j = W; j >= num; j--) {
                dp[j] = dp[j] + dp[j-num];
            }
        }
        return dp[W];
    }

    public int findTargetSumWays2(int[] nums, int S) {
        int sum = computeArraySum(nums);
        if (sum < S || (sum + S) % 2 == 1) {
            return 0;
        }
        int W = (sum + S) / 2;
        int[] dp = new int[W + 1];
        dp[0] = 1;
        for (int num : nums) {
            for (int i = W; i >= num; i--) {
                dp[i] = dp[i] + dp[i - num];
            }
        }
        return dp[W];
    }

    private int computeArraySum(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        return sum;
    }
}
