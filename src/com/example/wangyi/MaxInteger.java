package com.example.wangyi;

import java.util.Scanner;

/**
 * @author Pengllrn
 * @since <pre>2019/8/4 9:17</pre>
 */

/**
 * 辗转相除法
 * 1.对输入的超大数作处理
 * 2.欧几里得算法
 */
public class MaxInteger {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String aS = sc.nextLine();
        long b = sc.nextLong();
        long a = 0;
        for (int i = 0; i < aS.length(); i++){
            a = (a * 10 + aS.charAt(i) - '0') % b;
        }
        System.out.println(gcd(a, b));
    }

    private static long gcd(long a, long b){
        return a % b == 0 ? b : gcd(b, a % b);
    }
}
