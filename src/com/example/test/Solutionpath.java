package com.example.test;

/**
 * @author Pengllrn
 * @since <pre>2019/7/7 22:19</pre>
 */
public class Solutionpath {
    private int rows;
    private int cols;
    private char[] str;
    private char[] matrix;
    private int[] dt;

    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        if (matrix == null || matrix.length == 0 || matrix.length != rows * cols || str == null)
            return false;
        if (str.length == 0) return true;
        this.rows = rows;
        this.cols = cols;
        this.str = str;
        this.matrix = matrix;
        dt = new int[]{-cols, cols, -1, 1};
        boolean[] marked = new boolean[rows * cols];
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i] == str[0] && startFrom(i, 0, marked))
                return true;
        }
        return false;
    }

    private boolean startFrom(int i, int len, boolean[] marked) {
        if (str[len] != matrix[i]) return false;
        len++;
        marked[i] = true;
        if (len == str.length) return true;
        for (int k = 0; k < 4; k++) {
            int idx = i + dt[k];
            if (idx >= rows * cols || idx < 0 || marked[idx]) continue;
            marked[idx] = true;
            if (startFrom(idx, len, marked))
                return true;
            marked[idx] = false;
        }
        return false;
    }

    public static void main(String[] args) {
        boolean b = new Solutionpath().hasPath(new char[]{'a', 'b', 'c', 'e', 's', 'f', 'c', 's', 'a', 'd', 'e', 'e'},
                3, 4, "bcced".toCharArray());
        System.out.println(b);
    }
}
