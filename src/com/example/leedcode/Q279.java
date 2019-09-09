package com.example.leedcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Q279 {
    public static void main(String[] args) {
        int i = new Solution279_3().numSquares(429890323);//429890323
        System.out.println(i);
    }
}

/**
 * 给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, 25，36...）
 * 使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。
 * 43：25 9 9 跳过了16
 */
class Solution279 {//广度优先遍历

    //O(n^2) BFS
    public int numSquares(int n) {
        if (n <= 0)
            return -1;
        List<Integer> squares = generateSquare(n);
        Queue<Integer> queue = new LinkedList<>();
        queue.add(n);
        boolean[] marked = new boolean[n + 1];
        marked[n] = true;
        int level = 0;
        int x = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();//一轮
            level++;//一轮为一层
            while (size-- > 0) {
                int cur = queue.poll();
                for (int s : squares) {
                    x++;
                    int next = cur - s;
                    if (next < 0)
                        break;
                    if (next == 0) {
                        System.out.println(x);
                        return level;
                    }
                    if (marked[next])//减少重复计算，计算过程中遇到队列中已经有的数就不必再往队列里添加
                        continue;
                    marked[next] = true;
                    queue.add(next);
                }
            }
        }
        return level;
    }

    /**
     * 产生平方数列表
     *
     * @param n
     * @return
     */
    private List<Integer> generateSquare(int n) {
        List<Integer> squares = new ArrayList<>();
        int square = 1;
        int diff = 3;
        while (square <= n) {
            squares.add(square);
            square += diff;
            diff += 2;
        }
        return squares;
    }
}

class Solution279_2 {//动态规划

    public int numSquares(int n) {
        if (n <= 0)
            return -1;
        List<Integer> squares = generateSquare(n);
        int[] dp = new int[n + 1];//空间过大,可能导致栈溢出
        for (int i = 1; i <= n; i++) {
            dp[i] = 5;//任何一个数不会超过5个平方数组成
            for (int square : squares) {
                if (square > i)
                    break;
                dp[i] = Math.min(dp[i], dp[i - square] + 1);
            }
        }
        return dp[n];
    }

    private List<Integer> generateSquare(int n) {
        List<Integer> squares = new ArrayList<>();
        int square = 1;
        int diff = 3;
        while (square <= n) {
            squares.add(square);
            square += diff;
            diff += 2;
        }
        return squares;
    }
}

class Solution279_3 {
    public boolean isSquare(int n) {
        int num = (int) Math.sqrt(n);
        return num * num == n;
    }

    public int numSquares(int n) {
        if (isSquare(n)) return 1;
        while ((n & 3) == 0) {//n是4的倍数
            n >>= 2;
        }
        if ((n & 7) == 7) {//n是8的倍数
            return 4;
        }
        int num = (int) Math.sqrt(n);
        for (int i = 0; i <= num; i++) {
            if (isSquare(n - i * i)) {
                return 2;
            }
        }
        return 3;
    }
}
