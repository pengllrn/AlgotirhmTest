package com.example.zhaoyin;
import java.util.Scanner;

/**
 * @author Pengllrn
 * @since <pre>2019/9/6 17:10</pre>
 * A,B,C 三个字母的组合，组合的长度为n， 所有组合中不能连续出现2个以上的B，
 * 也不能同时出现两个C。比如n=2:AA,BA,CA,AB,BB,CB,AC,BC,CC中，CC不合法。所以有8组合法的。
 * 输入一个n，输出合法的组数。比如n=2,输出8.
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] dp = new int[n + 1];
        int[] endBB = new int[n + 1];
        int[] endB = new int[n + 1];
        dp[1] = 3;
        endB[1] = 1;
        for (int i = 2; i <= n; i++) {
            int endC =dp[i - 1] - (int) Math.pow(2, i - 2) * (i - 1);
            endB[i] = dp[i - 1] - endBB[i - 1];
            endBB[i] = endB[i - 1] - endBB[i - 1];
            dp[i] = dp[i - 1] + endB[i] + endC;
        }
        System.out.println(dp[n]);
    }
}


