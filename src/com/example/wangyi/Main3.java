package com.example.wangyi;

import java.util.Scanner;

/**
 * @author Pengllrn
 * @since <pre>2019/8/4 15:45</pre>
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int P = sc.nextInt();
        int Q = sc.nextInt();
        int a = 0, b = 1;
        int c = 1, d = 0;
        int row = 1;
        int col = 1;
        while (true){
            int up = a + c;
            int down = b + d;
            if(up == P && Q == down){
                System.out.println(row + " " + col);
                break;
            }
            if(up / (down + 0.0) < P / (Q + 0.0)){
                a = up;
                b = down;
                col = col * 2;
            }else {
                c = up;
                d = down;
                col = col * 2 - 1;
            }
            row++;
        }
    }
}
