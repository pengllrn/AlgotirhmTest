package com.example.leedcode;


/**
 * @author Pengllrn
 * @since <pre>2019/6/6 17:23</pre>
 */
public class Q300 {
    public static void main(String[] args) {
        int i = new Solution300_2().lengthOfLIS(new int[]{10, 9, 2, 5, 4, 7, 101, 18, 19});
        System.out.println(i);
    }
}

class Solution300 {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int n = nums.length;
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            int max = 1;
            for (int j = 0; j < i; j++)
                if (nums[i] > nums[j])
                    max = Math.max(max, dp[j] + 1);
            dp[i] = max;
        }
        int ret = 0;
        for (int r : dp) {
            ret = Math.max(ret, r);
        }
        return ret;
    }
}

class Solution300_2 {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int n = nums.length;
        int len = 0;
        int[] tails = new int[n];
        for (int i = 0; i < n; i++) {
            int index = binarySearch(tails, len, nums[i]);
            tails[index] = nums[i];
            if (index == len)
                len++;
        }
        return len;
    }

    private int binarySearch(int[] tails, int len, int key) {
        int left = 0, right = len;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (tails[mid] == key)
                return mid;
            if (tails[mid] < key)
                left = mid + 1;
            else
                right = mid;
        }
        return left;
    }
}
