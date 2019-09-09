package com.example.ieee;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class ViruBroadcast {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int s = in.nextInt();
        int t = in.nextInt();
        int[][] links = new int[m][2];
        for (int i = 0; i < m; i++) {
            links[i][0] = in.nextInt();
            links[i][1] = in.nextInt();
        }
        System.out.println(new Vius().broadcast(links, n, s, t));
    }
}

class Vius {

    public long broadcast(int[][] links, int n, int start, int ts) {
        Map<Integer, Node> map = new HashMap<>();
        for (int i = 0; i < n; i++) {//初始化节点
            Node node = new Node();
            node.linked = new HashSet<>();
            map.put(i, node);
        }
        for (int[] link : links) {//建立图
            int a = link[0];
            int b = link[1];
            map.get(a).linked.add(b);
            map.get(b).linked.add(a);
        }
        if (map.get(start).linked.size() == 0)
            return 0;
        map.get(start).from = 1;
        for (int t = 1; t <= ts; t++) {
            for (int i = 0; i < n; i++) {
                Node cur = map.get(i);
                if (cur.from == 0 || cur.linked.size() == 0)
                    continue;
                for (Integer j : cur.linked) {
                    map.get(j).to += cur.from;
                }
                cur.from = 0;
            }

            for (int i = 0; i < n; i++) {
                Node node = map.get(i);
                node.from = node.to;
                node.to = 0;
            }
        }
        long total = 0;
        for (int i = 0;i<n;i++){
            Node node = map.get(i);
            total+=node.from;
        }
        return total;
    }

    private class Node {
        long from;
        long to;
        Set<Integer> linked;
    }
}


