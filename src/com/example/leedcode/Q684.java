package com.example.leedcode;

import java.util.Arrays;

/**
 * @author Pengllrn
 * @since <pre>2019/6/29 11:05</pre>
 */
public class Q684 {
    public static void main(String[] args) {
        int[] redundantConnection = new Solution684().findRedundantConnection(new int[][]{{1, 2}, {2, 3}, {3, 4}, {1, 5}, {1, 4}});
        System.out.println(Arrays.toString(redundantConnection));
    }
}

class Solution684 {
    public int[] findRedundantConnection(int[][] edges) {
        if (edges == null || edges.length <= 1)
            return null;
        int n = edges.length;
        int[] index = new int[n + 1];
        for (int i = 1; i <= n; i++)
            index[i] = i;
        for (int[] edge : edges) {
            if (isConnect(index, edge[0], edge[1]))
                return new int[]{edge[0], edge[1]};
        }
        return null;
    }

    private boolean isConnect(int[] index, int i, int j) {
        while (index[i] != i)
            i = index[i];
        while (index[j] != j)
            j = index[j];
        if (i != j) {//连接
            index[j] = i;
        }
        return i == j;
    }
}
