package com.example.test.t72;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @author Pengllrn
 * @since <pre>2019/7/2 12:42</pre>
 */
public class Solution {
    private int[][] dct = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public ArrayList<Integer> printMatrix(int[][] matrix) {
        ArrayList<Integer> ans = new ArrayList();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return ans;
        int row = matrix.length;
        int col = matrix[0].length;
        int tol = row * col;
        int cnt = 0;
        int i = 0, j = 0;
        int cur = 0;
        boolean[][] marked = new boolean[row][col];
        while (cnt < tol) {
            ans.add(matrix[i][j]);
            marked[i][j] = true;
            cnt++;
            i += dct[cur][0];
            j += dct[cur][1];
            if (i == row || j == col ||marked[i][j]) {
                i -= dct[cur][0];
                j -= dct[cur][1];
                cur = (cur + 1) % 4;
                i += dct[cur][0];
                j += dct[cur][1];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        ArrayList<Integer> ans = new Solution().printMatrix(new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}});
        System.out.println(ans);
    }
}