package com.example.practice;

/**
 * @author Pengllrn
 * @since <pre>2019/8/2 9:37</pre>
 */
public class FindWOrd {
    private int[][] derect = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    private boolean flag;
    private int m, n;
    public boolean exist(char[][] board, String word) {
        if(board == null || board.length == 0 || board[0].length == 0 || word.length() == 0)
            return false;
        m = board.length;
        n = board[0].length;
        boolean[][] marked = new boolean[m][n];
        for(int i = 0; i < m; i ++){
            for(int j = 0; j < n; j++){
                if(board[i][j] == word.charAt(0)){
                    marked[i][j] = true;
                    bk(board, word, 1, marked, i, j);
                    marked[i][j] = false;
                }
            }
        }
        return flag;
    }

    private void bk(char[][] board, String word, int k, boolean[][] marked, int i, int j){
        if(k == word.length()){
            flag = true;
            return ;
        }
        char next = word.charAt(k);
        for(int[] d : derect){
            int ni = i + d[0];
            int nj = j + d[1];
            if(ni < 0 || ni == m || nj < 0 || nj == n || marked[ni][nj] || board[ni][nj] != next || flag)
                continue;
            marked[ni][nj] = true;
            bk(board, word, k + 1, marked, ni, nj);
            marked[ni][nj] = false;
        }
    }

    public static void main(String[] args) {
        char[][] b = new char[][]{{'A','B','C','E'}, {'S','F','C','S'},{'A','D','E','E'}};
        boolean abcced = new FindWOrd().exist(b, "ABCCED");
        System.out.println(abcced);
    }
}
