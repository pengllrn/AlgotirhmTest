package com.example.ieee;

import java.util.Scanner;

public class AliceCard {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] ci = new int[n];
        for (int i = 0; i < n; i++) {
            ci[i] = sc.nextInt();
        }
        Sol sol = new Sol();
        System.out.println(sol.solve(n, k, ci));
    }
}

class Sol {
    public int solve(int n, int k, int[] ci) {
        if (n <= k + 1) {//一次就能从任意位置翻开
            int min = ci[0];
            for (int i = 1; i < n; i++) {
                if (ci[i] < min)
                    min = ci[i];
            }
            return min;
        } else if (n <= 2 * k + 1) {//一次就能从部分位置翻开
            int min = ci[n - 1 - k];
            for (int i = n - 1 - k; i <= k; i++) {
                if (ci[i] < min)
                    min = ci[i];
            }
            return min;
        }
        //两次才能翻开
        else if (n < 4 * k + 2) {
            int min = ci[0] + ci[2 * k + 1];
            for (int i = 0; i < n-2*k-1; i++) {
                if (ci[i] + ci[2 * k + i] < min)
                    min = ci[i] + ci[2 * k + 1 + i];
            }
            return min;
        } else if (n % (2 * k + 1) == 0) {
            int cost = 0;
            for (int i = 0; i < n / (2 * k + 1); i++) {
                cost += ci[i];
            }
            return cost;
        }
        //多次翻开,剩余单边
        else if (n % (2 * k + 1) > k) {
            int shengyu = n % (2 * k + 1);
            int zushu = n / (2 * k + 1);
            int start = shengyu - k - 1;
            int end = n - 1 - (2 * k + 1) + shengyu;
            int casefront = ci[start];
            for (int j = 0; j < zushu; j++) {
                casefront += ci[shengyu + k + j * (2 * k + 1)];
            }
            int caseend = ci[end];
            for (int j = 0; j < zushu; j++) {
                caseend += ci[j * (2 * k + 1) + k];
            }
            if (caseend < casefront) {
                return caseend;
            } else return casefront;
        }
        //多次翻开剩余两边
        else {
            int shengyu = n % (2 * k + 1) + 2 * k + 1;
            int zushu = n / (2 * k + 1) + 1;
            int[] cost = new int[shengyu - 2 * k - 2];
            for (int i = k + 1; i <= shengyu - (k + 1); i++) {
                int zuoshengyu = i;
                int youshengyu = shengyu - i;
                int start = zuoshengyu - k - 1;
                int end = n - 1 - (2 * k + 1) + youshengyu;
                cost[i - k - 1] = ci[start] + ci[end];
                for (int j = 0; j < zushu; j++) {
                    cost[i - k - 1] += ci[zuoshengyu + k + j * (2 * k + 1)];
                }
            }
            int min = cost[0];
            for (int i = 1; i < shengyu - 2 * k - 2; i++) {
                if (cost[i] < min) min = cost[i];
            }
            return min;
        }
    }
}