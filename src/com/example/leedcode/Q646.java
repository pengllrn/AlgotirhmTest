package com.example.leedcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Pengllrn
 * @since <pre>2019/6/8 19:56</pre>
 */
public class Q646 {
    public static void main(String[] args) {
        int longestChain = new Solution646_2().findLongestChain(new int[][]{{1, 2}, {-1, 0}, {3, 6}});
        System.out.println(longestChain);
    }
}

class Solution646 {//动态规划解法

    public int findLongestChain(int[][] pairs) {
        if (pairs == null || pairs.length == 0 || pairs[0].length == 0)
            return 0;
        Arrays.sort(pairs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        int[] dp = new int[pairs.length];
        Arrays.fill(dp, 1);
        for (int i = 0; i < pairs.length; i++) {
            for (int j = 0; j < i; j++) {
                if (pairs[i][0] > pairs[j][1])
                    dp[i] = Math.max(dp[i], dp[j] + 1);
            }
        }
        int ret = 0;
        for (int i : dp) {
            ret = Math.max(ret, i);
        }
        return ret;
    }
}

class Solution646_2 {//贪心：找到可以放最多区间的个数

    public int findLongestChain(int[][] pairs) {
        if (pairs == null || pairs.length == 0 || pairs[0].length == 0)
            return 0;
        Arrays.sort(pairs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        int len = 1;
        int[] temp = pairs[0];
        for (int i = 1; i < pairs.length; i++) {
            if(pairs[i][0] > temp[1]){
                temp = pairs[i];
                len ++;
            }
        }
        return len;
    }

}