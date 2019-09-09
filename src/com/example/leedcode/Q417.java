package com.example.leedcode;

import java.util.ArrayList;
import java.util.List;

public class Q417 {
    public static void main(String[] args) {
        List<int[]> ints = new Solution417().pacificAtlantic(new int[][]{{1, 2, 2, 3, 5}, {3, 2, 3, 4, 4},
                {2, 4, 5, 3, 1}, {6, 7, 1, 4, 5}, {5, 1, 1, 2, 4}});
        System.out.println(ints);
    }
}

//[[1,2,2,3,5],[3,2,3,4,4],[2,4,5,3,1],[6,7,1,4,5],[5,1,1,2,4]]
class Solution417 {//错误答案
    private int row;
    private int col;
    private boolean[][] markedP;
    private boolean[][] markedA;

    public List<int[]> pacificAtlantic(int[][] matrix) {
        List<int[]> list = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return list;
        row = matrix.length;
        col = matrix[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (dfs(matrix, i, j))
                    list.add(new int[]{i, j});
            }
        }
        return list;
    }

    private boolean dfs(int[][] matrix, int i, int j) {
        markedP = new boolean[row][col];
        markedA = new boolean[row][col];
        return reachPacific(matrix, i, j) && reachAtlantic(matrix, i, j);
    }

    private boolean reachPacific(int[][] matrix, int i, int j) {
        if (markedP[i][j])
            return false;
        if (i - 1 < 0 || j - 1 < 0)
            return true;
        markedP[i][j] = true;
        boolean b1 = matrix[i - 1][j] <= matrix[i][j] && reachPacific(matrix, i - 1, j);
        boolean b2 = matrix[i][j - 1] <= matrix[i][j] && reachPacific(matrix, i, j - 1);
        return b1 || b2;
    }

    private boolean reachAtlantic(int[][] matrix, int i, int j) {
        if (markedA[i][j])
            return false;
        if (i + 1 >= row || j + 1 >= col)
            return true;
        markedA[i][j] = true;
        boolean b1 = matrix[i + 1][j] <= matrix[i][j] && reachAtlantic(matrix, i + 1, j);
        boolean b2 = matrix[i][j + 1] <= matrix[i][j] && reachAtlantic(matrix, i, j + 1);
        return b1 || b2;
    }

}

class Solution417_2 {//正确
    private int row;
    private int col;
    private int[][] direction = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};

    public List<int[]> pacificAtlantic(int[][] matrix) {
        List<int[]> list = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return list;
        row = matrix.length;
        col = matrix[0].length;
        boolean[][] canReachPacific = new boolean[row][col];
        boolean[][] canReachAtlantic = new boolean[row][col];
        for (int i = 0; i < row; i++) {
            dfs(matrix, i, 0, canReachPacific);
            dfs(matrix, i, col - 1, canReachAtlantic);
        }
        for (int i = 0; i < col; i++) {
            dfs(matrix, 0, i, canReachPacific);
            dfs(matrix, row - 1, i, canReachAtlantic);
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (canReachPacific[i][j] && canReachAtlantic[i][j])
                    list.add(new int[]{i, j});
            }
        }
        return list;
    }

    private void dfs(int[][] matrix, int i, int j, boolean[][] canReach) {
        if(canReach[i][j])
            return;
        canReach[i][j] = true;
        for (int [] d : direction){
            int nr = d[0] + i,nc = d[1] + j;
            if(nc < 0 || nc>= col || nr < 0 || nr >= row || matrix[nr][nc] < matrix[i][j])
                continue;
            dfs(matrix,nr,nc,canReach);
        }
    }
}
