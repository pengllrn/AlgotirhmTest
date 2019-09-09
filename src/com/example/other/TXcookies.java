package com.example.other;

import java.util.Scanner;

/**
 * @author Pengllrn
 * @since <pre>2019/8/3 12:38</pre>
 */
public class TXcookies {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int N = sc.nextInt();
        sc.close();
        if(M > N) return;
        if(M == 1) {
            System.out.println(N);
            return;
        }
        int re = binarySerach(N, M);
        System.out.println(re);
    }

    private static int binarySerach(int n, int m){
        int left = 1;
        int right = n;//n = 10, m= 2
        while (left < right){
            int mid = left + (right - left + 1) / 2;
            int tmp = minNeed(mid, m);
            if(tmp == n)
                return mid;
            if(tmp > n){
                right = mid - 1;
            }else
                left = mid;
        }
        return left;
    }

    private static int minNeed(int x, int m){
        int ret = 0;
        while (m > 0){
            ret += x;
            m--;
            x = (x + 1) >> 1;
        }
        return ret;
    }
}
