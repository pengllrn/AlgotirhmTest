package com.example.ieee;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;

public class AliceBook {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        ArrayList<int[]> list = new ArrayList<>();
        int[] nn = new int[t];
        for (int i = 0; i < t;i++){
            int n = in.nextInt();//book
            int m = in.nextInt();//m luck number
            int[] mmi = new int[m];
            for (int j = 0;j<m;j++){
                mmi[j] = in.nextInt();
            }
            list.add(mmi);
            nn[i] = n;
        }
        in.close();

        for (int i = 0;i<t;i++){
            int l = new ABook().timeOfOne(nn[i], list.get(i));
            System.out.println(l);
        }
    }
}

class ABook{

    public int timeOfOne(int n,int[] m){
        if(m.length == 0)
            return 0;
        Map<Integer,Integer> filetr = new HashMap<>();
        for (int v : m){
            if(filetr.containsKey(v))
                filetr.remove(v);
            else
                filetr.put(v,1);
        }
        HashSet<Integer> set = new HashSet<>(filetr.keySet());
        Map<Integer,Integer> map = new HashMap<>();
        PriorityQueue<Map.Entry<Integer,Integer>> queue = new PriorityQueue<>(new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o1.getKey() - o2.getKey();
            }
        });
        for (Integer i : set){
            map.put(i,1);
            queue.add(new AbstractMap.SimpleEntry<>(i, i));
        }
        int start = queue.peek().getKey();
        boolean[] end = new boolean[n];
        int cnt =0;
        while (start <= n){
            int origin = queue.poll().getValue();
            Integer times = map.get(origin);
            if(end[start-1]){
                end[start-1] = false;
                cnt--;
            }else {
                end[start-1] = true;
                cnt ++;
            }
            queue.add(new AbstractMap.SimpleEntry<>(origin * ++times,origin));
            map.put(origin,times);
            start = queue.peek().getKey();
        }
        return cnt;
    }
}
