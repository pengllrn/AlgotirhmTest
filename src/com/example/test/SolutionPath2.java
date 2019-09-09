package com.example.test;

/**
 * @author Pengllrn
 * @since <pre>2019/7/7 23:07</pre>
 */
public class SolutionPath2 {
    private int threshold;
    private int ans;
    private int[][] dt = new int[][]{{1,0},{-1, 0}, {0, 1},{0, -1}};
    private int rows;
    private int cols;
    public int movingCount(int threshold, int rows, int cols)
    {
        if(threshold <= 0 || rows <= 0 || cols <= 0)
            return 0;
        boolean[][] marked = new boolean[rows][cols];
        this.threshold = threshold;
        this.rows = rows;
        this.cols = cols;
        backtrack(marked, 0, 0);
        return ans;
    }

    private void backtrack(boolean[][] marked, int r, int c){
        if(weight(r, c) > threshold) return;
        ans++;
        marked[r][c] = true;
        for(int i = 0; i < 4; i++){
            int tr = r + dt[i][0];
            int tc = c + dt[i][1];
            if(tr >= rows || tr < 0 || tc >= cols || tc < 0 || marked[tr][tc]) continue;
            backtrack(marked, tr, tc);
        }
    }

    private int weight(int i, int j){
        int ret = 0;
        while(i != 0){
            ret += i % 10;
            i /= 10;
        }
        while(j != 0){
            ret += j % 10;
            j /= 10;
        }
        return ret;
    }

    public static void main(String[] args) {
        int i = new SolutionPath2().movingCount(2, 3, 4);
        System.out.println(i);
    }
}
