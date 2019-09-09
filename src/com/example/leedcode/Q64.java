package com.example.leedcode;

public class Q64 {
    public static void main(String[] args) {
        int i = new MinPath().minPathSum3(new int[][]{{1, 3, 1}});
        System.out.println(i);
    }
}

class MinPath {

    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0)
            return 0;
        int row = grid.length;
        int col = grid[0].length;
        int[][] dp = new int[row][col];
        dp[0][0] = grid[0][0];
        for (int i = 1; i < col; i++) {
            dp[0][i] = dp[0][i - 1] + grid[0][i];
        }
        for (int i = 1; i < row; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }

        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        return dp[row - 1][col - 1];
    }

    public int minPathSum3(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0)
            return 0;
        int rowLen = grid.length;
        int colLen = grid[0].length;
        int[] dp = new int[colLen];
        for (int i = 0; i < rowLen; i++) {
            for (int j = 0; j < colLen; j++) {
                if(j == 0){
                    dp[j] = dp[j] + grid[i][j];
                }else if(i == 0){
                    dp[j] = dp[j-1] + grid[i][j];
                }else
                    dp[j] = Math.min(dp[j],dp[j-1]) + grid[i][j];
            }
        }
        return dp[colLen - 1];
    }
}