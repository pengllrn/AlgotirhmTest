package com.example.leedcode;

/**
 * @author Pengllrn
 * @since <pre>2019/6/22 14:30</pre>
 */
public class Q240 {

}

class Solution240 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return false;
        int row = matrix.length;
        int col = matrix[0].length;
        int r = 0, c = col - 1;
        while (r < row && c >= 0) {
            int val = matrix[r][c];
            if (target == val)
                return true;
            else if (target < val)
                c--;
            else
                r++;
        }
        return false;
    }
}
