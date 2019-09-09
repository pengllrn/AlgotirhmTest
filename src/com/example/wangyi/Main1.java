package com.example.wangyi;
import java.util.Scanner;

/**
 * @author Pengllrn
 * @since <pre>2019/8/4 13:56</pre>
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[][] windows = new int[N + M][5];
        for (int i = 0; i < N; i++){
            int[] win = new int[5];
            for (int j = 0; j < 4; j++){
                win[j] = sc.nextInt();
            }
            win[4] = i + 1;
            windows[i] = win;
        }
        int[][] clicks = new int[M][2];
        for (int i = 0 ; i < M; i++){
            clicks[i][0] = sc.nextInt();
            clicks[i][1] = sc.nextInt();
        }
        int k = N - 1;
        for (int i = 0; i < M; i++){
            int c1 = clicks[i][0];
            int c2 = clicks[i][1];
            boolean flag = false;
            for (int j = k; j >= 0; j--){
                int[] win = windows[j];
                if (win == null) continue;
                if(shot(win, c1, c2)){
                    windows[j] = null;
                    windows[k + 1] = win;
                    System.out.println(win[4]);
                    flag = true;
                    k++;
                    break;
                }
            }
            if(!flag) System.out.println(-1);
        }
    }

    private static boolean shot(int[] window, int c1, int c2){
        return c1 >= window[0] && c1 <= window[0] + window[2]
                && c2 >= window[1] && c2 <= window[1] + window[3];
    }
}
