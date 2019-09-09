package com.example.xiaohongshu;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author Pengllrn
 * @since <pre>2019/9/3 19:57</pre>
 */
public class Main2 {
    private static int[][] direction = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();
        char[][] arr = new char[N][N];
        int si = 0, sj = 0;
        for (int i = 0; i < N; i++) {
            String line = sc.nextLine();
            for (int j = 0; j < N; j++) {
                arr[i][j] = line.charAt(j);
                if(arr[i][j] == 'S'){
                    si = i;
                    sj = j;
                    arr[i][j] = '#';
                }
            }
        }
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(si, sj));
        int cnt = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            cnt++;
            while (size-- > 0) {
                Pair pair = queue.remove();
                for (int[] d : direction) {
                    int ni = (pair.i + d[0] + N) % N;
                    int nj = (pair.j + d[1] + N) % N;
                    if(arr[ni][nj] == 'E') {
                        System.out.println(cnt);
                        return;
                    }
                    if(arr[ni][nj] == '#') continue;
                    arr[ni][nj] = '#';
                    queue.add(new Pair(ni, nj));
                }
            }
        }
        System.out.println(-1);
    }

    private static class Pair{
        int i, j;
        public Pair(int i, int j){
            this.i = i;
            this.j = j;
        }
    }

}

/*
5
.#...
..#S.
.E###
.....
.....

 */