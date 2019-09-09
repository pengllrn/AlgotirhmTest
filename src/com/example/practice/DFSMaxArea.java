package com.example.practice;

/**
 * @author Pengllrn
 * @since <pre>2019/7/30 9:54</pre>
 */
public class DFSMaxArea {
    private int[][] derect = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public int maxAreaOfIsland(int[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0)
            return 0;
        int m = grid.length;
        int n = grid[0].length;
        int ans = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 0) continue;
                ans = Math.max(backtrack(grid, i, j), ans);
            }
        }
        return ans;
    }

    private int backtrack(int[][] grid, int i, int j){
        if(grid[i][j] == 0)
            return 0;
        int cnt = 1;
        grid[i][j] = 0;
        for(int[] d : derect){
            int ni = i + d[0], nj = j + d[1];
            if(ni < 0 || ni == grid.length || nj < 0 || nj == grid[0].length || grid[ni][nj] == 0){
                continue;
            }
            cnt += backtrack(grid, ni, nj);
        }
        return cnt;
    }

    public static void main(String[] args) {
        int[][] area = new int[][]{{1,1,0,0,0},{1,1,0,0,0},{0,0,0,1,1},{0,0,0,1,1}};
        int i = new DFSMaxArea().maxAreaOfIsland(area);
        System.out.println(i);
    }
}
