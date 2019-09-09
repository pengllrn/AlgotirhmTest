package com.example.other;

/**
 * @author Pengllrn
 * @since <pre>2019/6/8 22:25</pre>
 */
public class LestCommonSubsenquence {
}

//最长公共子序列
class SolutionLestCommonSubsenquence {
    public int lengthOfLCS(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0)
            return 0;
        int[][] dp = new int[nums1.length + 1][nums2.length + 1];
        for (int i = 1; i <= nums1.length; i++) {
            for (int j = 1; j <= nums2.length; j++) {
                if (nums1[i - 1] == nums2[j - 1])
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return dp[nums1.length][nums2.length];
    }
}


