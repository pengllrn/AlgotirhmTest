package com.example.leedcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Pengllrn
 * @since <pre>2019/6/4 9:26</pre>
 */
public class Q413 {
    public static void main(String[] args) {
        int i = new Solution413().numberOfArithmeticSlices(new int[]{1, 2, 3, 4, 5, 7, 3, 2, 1});
        System.out.println(i);
    }
}


class Solution413 {

    public int numberOfArithmeticSlices(int[] A) {
        if (A == null || A.length < 3)
            return 0;
        int[] diff = new int[A.length];
        for (int i = 1; i < A.length; i++) {
            diff[i] = A[i] - A[i - 1];
        }
        List<Integer> slices = new ArrayList<>();
        int cnt = 1;
        for (int i = 2; i < A.length; i++) {
            if (diff[i] == diff[i - 1])
                cnt++;
            else if (cnt >= 2) {
                slices.add(cnt + 1);
                cnt = 1;
            }
        }
        if (cnt >= 2)
            slices.add(cnt + 1);
        int ans = 0;
        for (int k : slices) {//5-> 3+2+1
            for (int i = 3; i <= k; i++) {
                ans += (k - i) + 1;
            }
        }
        return ans;
    }

    public int numberOfArithmeticSlices2(int[] A) {
        if (A == null || A.length < 3)
            return 0;
        int[] dp = new int[A.length];//dp[i] 表示以 A[i] 为结尾的等差递增子区间的个数
        for (int i = 2; i < A.length; i++) {
            if(A[i] - A[i-1] == A[i-1] - A[i-2])
                dp[i] = dp[i-1] + 1;
        }
        int cnt = 0;
        for (int value : dp) cnt += value;
        return cnt;
    }
}