package com.example.main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

import javafx.util.Pair;

/**
 * @author Pengllrn
 * @since <pre>2019/7/28 15:30</pre>
 */
public class Main2 {
    private static boolean flag = false;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String in = sc.nextLine();
        String[] strs = in.split(" ");
        Map<Character, Character> map = new HashMap<>();
        for (String str : strs) {
            if(str.length() < 2){
                System.out.println(false);
                return;
            }
            char first = str.charAt(0);
            char seconde = str.charAt(str.length() - 1);
            if(first == seconde)
                continue;
            if (map.containsKey(first)) {
                System.out.println(false);
                return;
            } else {
                map.put(first, seconde);
            }
        }
        System.out.println(backtracking(map, strs[0].charAt(0), strs[0].charAt(0)));
    }

    private static boolean backtracking(Map<Character, Character> map, Character start, Character key) {
        Character value = map.get(key);
        if(value == null){
            if (key == start && map.isEmpty()){
                flag = true;
                return flag;
            }
            return flag;
        }
        map.remove(key);
        backtracking(map,start, value);
        return flag;
    }
}

class Solution{
    public int minPathLength(int[][] grids, int tr, int tc) {
        if(grids == null || grids.length <= tr || grids[0].length <= tc)
            return -1;
        int[][] direct = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int row = grids.length;
        int col = grids[0].length;
        if(grids[0][0] == 0) return -1;
        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
        queue.add(new Pair<>(0, 0));
        int level = 0;
        while(queue.isEmpty()){
            int size = queue.size();
            level ++;
            while(size-- != 0){
                Pair<Integer, Integer> local = queue.remove();
                for(int[] d : direct){
                    int nr = local.getKey() + d[0], nc = local.getValue() + d[1];
                    if(nr < 0 || nr == row || nc < 0 || nc == col || grids[nr][nc] == 0)
                        continue;
                    queue.add(new Pair<>(nr, nc));
                }
            }
        }
        return level;
    }
}
