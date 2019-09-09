package com.example.leedcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Pengllrn
 * @since <pre>2019/6/25 20:10</pre>
 */
public class Q785 {
    public static void main(String[] args) {
        boolean bipartite = new Solution785_2().isBipartite(new int[][]{{}, {2, 4, 6}, {1, 4, 8, 9}, {7, 8}, {1, 2, 8, 9}, {6, 9}, {1, 5, 7, 8, 9}, {3, 6, 9}, {2, 3, 4, 6, 9}, {2, 4, 5, 6, 7, 8}});
        System.out.println(bipartite);
    }
}

/**
 * [[1,2,3], [0,2], [0,1,3], [0,2]]
 * 0----1
 * | \  |
 * |  \ |
 * 3----2
 */
class Solution785 {
    public boolean isBipartite(int[][] graph) {
        if (graph == null || graph.length == 0)
            return true;
        int row = graph.length;
        int[] marked = new int[row];
        for (int i = 0; i < row; i++) {
            if (marked[i] == 0) {//未访问过
                Queue<Integer> queue = new LinkedList<>();
                queue.add(i);
                int flag = -1;
                while (!queue.isEmpty()) {
                    int size = queue.size();
                    flag = -flag;
                    while (size-- != 0) {
                        int val = queue.remove();
                        if (marked[val] == -flag)
                            return false;//异常
                        marked[val] = flag;
                        for (int v : graph[val]) {
                            if (marked[v] == 0)
                                queue.add(v);
                        }
                    }
                }
            }
        }
        return true;
    }
}

class Solution785_2 {
    public boolean isBipartite(int[][] graph) {
        if (graph == null || graph.length == 0)
            return true;
        int n = graph.length;
        int[] colors = new int[n];
        for (int i = 0; i < n; i++) {
            if (colors[i] == 0 && !isBipartite(i, -1, colors, graph))
                return false;
        }
        return true;
    }

    private boolean isBipartite(int curNode, int curColor, int[] colors, int[][] graph) {
        if (colors[curNode] != 0)//已经被着色了
            return curColor == colors[curNode];//是否与希望被着的颜色点一致
        colors[curNode] = curColor;
        for (int v : graph[curNode]) {
            if (!isBipartite(v, -curColor, colors, graph))
                return false;
        }
        return true;
    }
}