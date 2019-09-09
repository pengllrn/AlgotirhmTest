package com.example.practice;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Pengllrn
 * @since <pre>2019/8/1 21:37</pre>
 */
public class DFSPacific {
    private int[][] derect = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    private int m, n;
    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        List<List<Integer>> ans = new ArrayList<>();
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return ans;
        m = matrix.length;
        n = matrix[0].length;
        int[][] marked = new int[m][n];
        for(int i = 0; i < n; i++){
            dfs(matrix, 0, i, 1, marked);
        }
        for(int j = 1; j < m; j++){
            dfs(matrix, j, 0, 1, marked);
        }
        for(int i = 0; i < n; i++){
            dfs(matrix, m - 1, i, -1, marked);
        }
        for(int j = 1; j < m; j++){
            dfs(matrix, j, n - 1, -1, marked);
        }
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(marked[i][j] == 0){
                    List<Integer> list = new ArrayList<>();
                    list.add(i);
                    list.add(j);
                    ans.add(list);
                }
            }
        }
        return ans;
    }

    private void dfs(int[][] matrix, int i, int j, int v, int[][] marked){
        marked[i][j] += v;
        for(int[] d : derect){
            int ni = i + d[0];
            int nj = j + d[1];
            if(ni < 0 || ni == m || nj < 0 || nj == n || marked[ni][nj] != 0 || matrix[ni][nj] < matrix[i][j])
                continue;
            dfs(matrix, ni, nj, v, marked);
        }
    }

    public static void main(String[] args) {
        int[][] in = new int[][]{{1,2,2,3,5},{3,2,3,4,4},{2,4,5,3,1},{6,7,1,4,5},{5,1,1,2,4}};
        List<List<Integer>> lists = new DFSPacific().pacificAtlantic(in);
        for (List l : lists){
            System.out.println(l);
        }
    }
}
