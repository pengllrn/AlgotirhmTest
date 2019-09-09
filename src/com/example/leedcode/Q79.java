package com.example.leedcode;

public class Q79 {
}

class Solution79 {
    private int row;
    private int col;
    private int[][] direction = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0].length == 0)
            return false;
        row = board.length;
        col = board[0].length;
        boolean[][] marked = new boolean[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == word.charAt(0) && backtracking(board, word, i, j, 0, marked))
                    return true;
            }
        }
        return false;
    }

    private boolean backtracking(char[][] board, String word, int r, int c, int len, boolean[][] marked) {
        if (len == word.length())
            return true;
        if (r < 0 || r >= row || c < 0 || c >= col || marked[r][c] || word.charAt(len) !=
                board[r][c])
            return false;
        marked[r][c] = true;
        for (int[] d : direction) {
            if (backtracking(board, word, r + d[0], c + d[1], len + 1, marked))
                return true;
        }
        marked[r][c] = false;
        return false;
    }
}
