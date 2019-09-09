package com.example.leedcode;

import java.util.Arrays;

/**
 * @author Pengllrn
 * @since <pre>2019/6/21 23:06</pre>
 */
public class Q566 {
    public static void main(String[] args) {
        int[][] ints = new SolutionQ566().matrixReshape(new int[][]{{1, 2}, {4, 5}}, 4, 1);
        for (int[] in : ints)
            System.out.println(Arrays.toString(in));;
    }
}

class SolutionQ566 {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        if (nums == null || nums.length == 0 || nums[0].length == 0)
            return nums;
        int row = nums.length;
        int col = nums[0].length;
        if (row * col != r * c)
            return nums;

        int[][] ans = new int[r][c];
        int index = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                ans[index / c][index++ % c] = nums[i][j];
            }
        }
        return ans;
    }
}
