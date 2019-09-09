package com.example.other;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import javafx.util.Pair;

public class GridMinPath {
    public static void main(String[] args) {
        int i = new SolutionGridMinPath().minPathLength(null, 0, 0);
        System.out.println(i);
    }
}

/**
 * 计算在网格中从原点到特定点的最短路径长度
 * 1 表示可以经过某个位置，求解从 (0, 0) 位置到 (tr, tc) 位置的最短路径长度。
 */
class SolutionGridMinPath {

    /**
     * 如不可达，则返回-1，否则返回最短路径长度
     *
     * @param grids
     * @param tr
     * @param tc
     * @return
     */
    public int minPathLength(int[][] grids, int tr, int tc) {
        if (grids == null || grids.length == 0 || grids[0].length == 0 || tr < 0 || tc < 0)
            return -1;
        if (tr == 0 && tc == 0) {
            return grids[0][0] == 1 ? 0 : -1;
        }
        int lenRow = grids.length;
        int lenCol = grids[0].length;
        if (tr >= lenRow || tc >= lenCol)
            return -1;
        int[][] direction = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
        queue.add(new Pair<>(0, 0));
        int pathLength = -1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            pathLength++;
            while (size-- > 0) {
                Pair<Integer, Integer> pair = queue.poll();
                int cr = pair.getKey(), cc = pair.getValue();
                grids[cr][cc] = 0;//遍历标记
                for (int[] dct : direction) {
                    int nr = cr + dct[0], nc = cc + dct[1];
                    if (nr < 0 || nr >= lenRow || nc < 0 || nc >= lenCol || grids[nr][nc] == 0)
                        continue;
                    if (nr == tr && nc == tc)
                        return pathLength;
                    queue.add(new Pair<>(nr, nc));
                }
            }
        }
        return -1;
    }
}
