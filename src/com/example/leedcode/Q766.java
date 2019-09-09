package com.example.leedcode;

/**
 * @author Pengllrn
 * @since <pre>2019/6/23 20:43</pre>
 */
public class Q766 {
    public static void main(String[] args) {
        Solution766_2 solution766 = new Solution766_2();
        boolean re = solution766.isToeplitzMatrix(new int[][]{{1, 2}, {2, 2}});
        System.out.println(re);
    }
}

class Solution766 {
    public boolean isToeplitzMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return false;
        int row = matrix.length;
        int col = matrix[0].length;
        //一竖
        for (int i = 0; i < row - 1; i++) {
            int r = i, c = 0;
            while (r + 1 < row && c + 1 < col) {
                if (matrix[r + 1][c + 1] != matrix[r][c])
                    return false;
                r++;
                c++;
            }
        }
        //一行
        for (int i = 1; i < col - 1; i++) {
            int c = i, r = 0;
            while (r + 1 < row && c + 1 < col) {
                if (matrix[r + 1][c + 1] != matrix[r][c])
                    return false;
                r++;
                c++;
            }
        }
        return true;
    }
}

class Solution766_2 {
    private int row;
    private int col;

    public boolean isToeplitzMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return false;
        row = matrix.length;
        col = matrix[0].length;
        return isShift(matrix, 1);
    }

    private boolean isShift(int[][] matrix, int nextLine) {
        if (nextLine >= row)
            return true;
        for (int i = 0; i < col - 1; i++) {
            if (matrix[nextLine - 1][i] != matrix[nextLine][i + 1])
                return false;
        }
        return isShift(matrix, nextLine + 1);
    }
}
