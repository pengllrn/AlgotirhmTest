package com.example.dji;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Pengllrn
 * @since <pre>2019/8/4 20:26</pre>
 */
public class Main3 {
    private static class Pair {
        int d, v;

        Pair(int d, int v) {
            this.d = d;
            this.v = v;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int N = sc.nextInt();//路标数
            int P = sc.nextInt();//path 连通数
            int C = sc.nextInt();//比赛轮数

            ArrayList<ArrayList<Pair>> links = new ArrayList<>();
            for (int i = 0; i < N; i++) {//初始化links
                links.add(new ArrayList<>());
            }

            int a, b, v;
            for (int i = 0; i < P; i++) {//建立graph
                a = sc.nextInt();
                b = sc.nextInt();
                v = sc.nextInt();
                links.get(a).add(new Pair(b, v));
                links.get(b).add(new Pair(a, v));
            }
            //Dijkstra算法
            int[] dist = new int[N];//路径和
            Arrays.fill(dist, Integer.MAX_VALUE);
            dist[0] = 0;
            boolean[] marked = new boolean[N];
            int[] path = new int[N];//路径
            int s = 0;
            while (s != -1) {
                marked[s] = true;//标记，不再重复访问
                ArrayList<Pair> pair = links.get(s);
                int k = -1;
                for (Pair p : pair) {
                    int n = p.d;
                    if (dist[s] + p.v < dist[n]) {//更新dist
                        path[n] = s;
                        dist[n] = dist[s] + p.v;
                    }
                    if (marked[n]) continue;
                    if (k == -1 || dist[s] > dist[n]) k = n;
                }
                s = k;
            }
            //累计和
            int ans = 0;
            for (int i = 0; i < C; i++) {
                ans += dist[sc.nextInt()];
            }
            System.out.println(ans);
        }
    }
}



