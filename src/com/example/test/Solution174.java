package com.example.test;

/**
 * @author Pengllrn
 * @since <pre>2019/7/29 11:52</pre>
 */
public class Solution174 {
    public int calculateMinimumHP(int[][] dungeon) {
        if(dungeon == null || dungeon.length == 0 || dungeon[0].length == 0)
            return 0;
        int row = dungeon.length - 1;
        int col = dungeon[0].length - 1;
        int[] dp = new int[col + 1];
        for(int i = row; i >= 0; i--){
            for(int j = col; j >= 0; j--){
                int v = dungeon[i][j];
                if(j == col){
                    dp[j] = need(v - dp[j]);
                }else if(i == row){
                    dp[j] = need(v - dp[j + 1]);
                }else{
                    dp[j] = Math.min(need(v - dp[j]),need(v - dp[j + 1]));
                }
            }
        }
        return dp[0] + 1;
    }

    private int need(int tmp){
        return tmp >= 0 ? 0 : Math.abs(tmp);
    }

    public static void main(String[] args) {
        int[][] dun = new int[][]{{-2,-3,3},{-5,-10,1},{10,30,-5}};
        int i = new Solution174().calculateMinimumHP(dun);
        System.out.println(i);
    }
}
