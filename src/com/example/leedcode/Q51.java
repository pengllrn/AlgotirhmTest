package com.example.leedcode;

import java.util.ArrayList;
import java.util.List;

public class Q51 {
    public static void main(String[] args) {
        List<List<String>> lists = new Solution51().solveNQueens(8);
        System.out.println(lists.size());
    }
}

class Solution51 {
    private boolean[] colUsed;
    private boolean[][] marked;
    private int n;

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        colUsed = new boolean[n];
        marked = new boolean[n][n];
        this.n = n;
        backtrack(ans, n, new ArrayList<>(), 0);
        return ans;
    }

    private void backtrack(List<List<String>> ans, int n, List<String> queue, int row) {
        if (queue.size() == n) {
            ans.add(new ArrayList<>(queue));
            return;
        }
        for (int i = 0; i < n; i++) {//选择第row行中的某个位置放一个Q
            if (colUsed[i] || beAttack(row, i)) {
                continue;
            }
            colUsed[i] = true;
            marked[row][i] = true;
            queue.add(fillLine(i, n));
            backtrack(ans, n, queue, row + 1);
            queue.remove(queue.size() - 1);
            marked[row][i] = false;
            colUsed[i] = false;
        }
    }

    private boolean beAttack(int r, int c) {//斜方向上可不可以被攻击
        int tempC = c;
        int tempR = r;
        while (r >= 0 && c >= 0) {
            if (marked[r--][c--])
                return true;
        }
        c = tempC;
        r = tempR;
        while (r >= 0 && c < n) {
            if (marked[r--][c++])
                return true;
        }
        return false;
    }

    private String fillLine(int i, int n) {
        StringBuilder line = new StringBuilder();
        for (int j = 0; j < i; j++)
            line.append(".");
        line.append("Q");
        for (int j = i + 1; j < n; j++)
            line.append(".");
        return line.toString();
    }
}
