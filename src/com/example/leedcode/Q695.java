package com.example.leedcode;

import java.util.AbstractMap;
import java.util.Map;
import java.util.Stack;

import javafx.util.Pair;

public class Q695 {
    public static void main(String[] args) {
        int i = new Solution695_3().maxAreaOfIsland(new int[][]{{1, 1, 0, 0, 0}, {1, 1, 0, 0, 0}, {0, 0, 1, 1, 0}, {0, 1, 1, 1, 1}});
        System.out.println(i);
    }
}

/**
 * [[1,1,0,0,0],[1,1,0,0,0],[0,0,0,1,1],[0,0,0,1,1]]
 */
class Solution695 {

    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0)
            return 0;
        int row = grid.length;
        int col = grid[0].length;
        int[][] direction = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        boolean[][] marked = new boolean[row][col];
        Stack<Map.Entry<Integer, Integer>> stack = new Stack<>();
        int cnt = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (marked[i][j] || grid[i][j] == 0)
                    continue;
                marked[i][j] = true;
                stack.push(new AbstractMap.SimpleEntry<>(i, j));
                int path = 0;
                while (!stack.isEmpty()) {
                    path++;
                    Map.Entry pair = stack.pop();
                    for (int[] d : direction) {
                        int nrow = (int) pair.getKey() + d[0];
                        int ncol = (int) pair.getValue() + d[1];
                        if (nrow < 0 || nrow >= row || ncol < 0 || ncol >= col || marked[nrow][ncol])
                            continue;
                        if (grid[nrow][ncol] == 1)
                            stack.push(new AbstractMap.SimpleEntry<>(nrow, ncol));
                        marked[nrow][ncol] = true;
                    }
                }
                cnt = Math.max(path, cnt);
            }
        }
        return cnt;
    }
}

class Solution695_2 {

    private int[][] direction = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    private int row = 0;
    private int col = 0;

    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0)
            return 0;
        this.row = grid.length;
        this.col = grid[0].length;
        int maxNum = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                maxNum = Math.max(dfs(grid, i, j), maxNum);
            }
        }
        return maxNum;
    }

    /**
     * 从i,j坐标开始，连续的1的个数
     */
    private int dfs(int[][] grid, int i, int j) {
        if (i < 0 || i >= row || j < 0 || j >= col || grid[i][j] == 0)
            return 0;
        int area = 1;
        grid[i][j] = 0;
        for (int[] d : direction) {
            area += dfs(grid, i + d[0], j + d[1]);
        }
        return area;
    }
}

class Solution695_3 {

    private int row = 0;
    private int col = 0;
    private int area = 0;

    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0)
            return 0;
        this.row = grid.length;
        this.col = grid[0].length;
        int maxNum = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) {
                    area = 0;
                    dfs(grid,i,j);
                    maxNum = maxNum > area ? maxNum : area;
                }
            }
        }
        return maxNum;
    }

    private int dfs(int[][] grid, int i, int j) {
        if (i < 0 || i >= row || j < 0 || j >= col || grid[i][j] == 0)
            return 0;
        area++;
        grid[i][j] = 0;
        dfs(grid, i + 1, j);//四个方向
        dfs(grid, i - 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i, j - 1);
        return area;
    }
}
