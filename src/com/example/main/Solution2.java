package com.example.main;

/**
 * @author Pengllrn
 * @since <pre>2019/7/31 12:24</pre>
 */
public class Solution2 {
    public int lengthOfLCS(int[] nums1, int[] nums2) {
        int n1 = nums1.length, n2 = nums2.length;
        int[] dp = new int[n2];
        for (int i = 0; i < n1; i++) {
            for (int j = 0; j < n2; j++) {
                if (nums1[i] == nums2[j]){
                    if(j == 0 || i == 0) dp[j] = 1;
                    else dp[j] = dp[j - 1] + 1;
                }else {
                    if(j != 0) {
                        if(i == 0) dp[j] = dp[j - 1];
                        else dp[j] = Math.max(dp[j], dp[j - 1]);
                    }
                }
            }
        }
        return dp[n2 - 1];
    }

    public static void main(String[] args) {
        int i = new Solution2().lengthOfLCS(new int[]{1, 1, 3}, new int[]{1, 1, 3});
        System.out.println(i);
    }
}
