package com.example.practice;

import java.util.AbstractMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * @author Pengllrn
 * @since <pre>2019/7/25 15:41</pre>
 */
public class BSTMinPath {
    private int[][] dict = new int[][]{{1,0},{-1, 0}, {0, 1}, {0, -1}};
    public int minPathLength(int[][] grids, int tr, int tc) {
        if(grids == null || grids.length == 0 || grids[0].length == 0 || grids[0][0] == 0)
            return -1;
        int row = grids.length;
        int col = grids[0].length;
        int cnt = 0;
        Queue<Map.Entry<Integer, Integer>> queue = new LinkedList<>();
        queue.add(new AbstractMap.SimpleEntry<>(0, 0));
        while (!queue.isEmpty()){
            int size = queue.size();
            cnt++;
            while ((size-- != 0)){
                Map.Entry<Integer, Integer> pos = queue.poll();
                int cr = pos.getKey();
                int cc = pos.getValue();
                grids[cr][cc] = 0;
                for (int[] d : dict){
                    int nr = cr + d[0], nc = cc + d[1];
                    if(nr < 0 || nr >= row || nc < 0 || nc >= col || grids[nr][nc] == 0)
                        continue;
                    if(nr == tr && nc == tc){
                        return cnt;
                    }
                    queue.add(new AbstractMap.SimpleEntry<>(nr, nc));
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int i = new BSTMinPath().minPathLength(new int[][]{{1, 1, 1}}, 0, 2);
        System.out.println(i);
    }
}
