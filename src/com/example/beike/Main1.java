package com.example.beike;

import java.util.Scanner;

/**
 * @author Pengllrn
 * @since <pre>2019/8/10 19:04</pre>
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long a = sc.nextLong(), b = sc.nextLong();
        long ra = a, rb = b;
        long diff = Math.abs(a - b);
        for (int i = 2; i < n; i++){
            long t = sc.nextLong();
            if(Math.abs(t - b) < diff){
                diff = Math.abs(t - b);
                ra = b;
                rb = t;
            }
            a = b;
            b = t;
        }
        System.out.println(ra + " " + rb);
    }
}
