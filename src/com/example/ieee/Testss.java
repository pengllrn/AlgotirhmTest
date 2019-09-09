package com.example.ieee;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Set;

public class Testss {
    public static void main(String[] args) {
//        int i = gcd1(250080424, 1024334234);
//        System.out.println(i);
//        int[][] arr = new int[][]{{3,2,4},{2,1,6},{4,3,8}};
//        Arrays.sort(arr,(o1,o2)->o1[0]-o2[0]);
//        System.out.println(Arrays.toString(arr[2]));
//        long ll = 10 * 100000007;
//        System.out.println(Long.MAX_VALUE);
        Map<Integer,Integer> filetr = new HashMap<>();
        for (int v : new int[]{12,2,4,4,6,6,6}){
            if(filetr.containsKey(v))
                filetr.remove(v);
            else
                filetr.put(v,1);
        }
        HashSet<Integer> set = new HashSet<>(filetr.keySet());
//        set.add(5);
        set.add(10);
        System.out.println(set);
//        PriorityQueue queue = new PriorityQueue<Integer>();
//        for (Integer ii : filetr.keySet()){
//            queue.add(ii);
//        }
//        System.out.println(queue);
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.add(1);
        queue.add(1);
        queue.add(2);
        queue.add(0);
        System.out.println(queue);
    }


    public static int gcd1(int m, int n) {
        int i=0;
        int t = m % n;
        while (t != 0) {
            System.out.println(++i);
            m = n;
            n = t;
            t = m % n;
        }
        return n;
    }
}
