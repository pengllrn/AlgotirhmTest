package com.example.bytedance;

import java.util.Scanner;

/**
 * @author Pengllrn
 * @since <pre>2019/7/1 9:27</pre>
 */
public class Main4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int D = sc.nextInt();
        int[] dist = new int[N];
        for (int i = 0; i < N; i++) {
            dist[i] = sc.nextInt();
        }
        long i = new Solution4_2().totalProgram(dist, D);
        System.out.println(i);
    }
}

class Solution4 {
    private final int mod = 99997867;
    private int ans = 0;

    public int totalProgram(int[] dist, int D) {
        for (int i = 0; i < dist.length - 2; i++) {
            arraignment(dist, i, D, 1);
        }
        return ans;
    }

    private void arraignment(int[] dist, int start, int D, int cnt) {
        if (cnt == 3) {
            ans++;
            if (ans >= mod) ans = ans % mod;
            return;
        }

        for (int i = start + 1; i < dist.length - (2 - cnt); i++) {
            int left = D - dist[i] + dist[start];
            if (left < 0) break;
            arraignment(dist, i, left, cnt + 1);
        }
    }
}

class Solution4_2 {
    public long totalProgram(int[] dist, int D) {
        int ans = 0;
        for (int i = 0,j = 0;i<dist.length;i++){
            while (i >= 2 && (dist[i] - dist[j]) > D)
                j++;
            ans += computeCn(i - j);
        }
        return ans % 99997867;
    }

    private long computeCn(long n) {
        return n * (n - 1) / 2;
    }
}
