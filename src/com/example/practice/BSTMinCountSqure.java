package com.example.practice;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Pengllrn
 * @since <pre>2019/7/25 16:36</pre>
 */
public class BSTMinCountSqure {
    public int numSquares(int n){
        if(n <= 0) return -1;
        List<Integer> squares = computeSquares(n);
        Queue<Integer> queue = new LinkedList<>();
        queue.add(n);
        boolean[] marked = new boolean[n + 1];
        marked[n] = true;
        int cnt = 0;
        while (!queue.isEmpty()){
            int size = queue.size();
            cnt++;
            while (size-- != 0){
                int v = queue.remove();
                for (Integer s : squares){
                    int next = v - s;
                    if(next < 0)
                        break;
                    if(next == 0)
                        return cnt;
                    if(marked[next])
                        continue;
                    marked[next] = true;
                    queue.add(next);
                }
            }
        }
        return cnt;
    }

    private List<Integer> computeSquares(int n){
        List<Integer> list = new ArrayList<>();
        int v = 1;
        int diff = 3;
        while (v <= n){
            list.add(v);
            v += diff;
            diff += 2;
        }
        return list;
    }
}
