package com.example.dji;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int N = sc.nextInt();//bug总数
            int A = sc.nextInt();//效率倍数
            int X = sc.nextInt();//咖啡数
            if( X >= 8) X = 8;
            int[] bugs = new int[N];
            int sum = 0;
            for (int i = 0; i < N; i++){
                bugs[i] = sc.nextInt();
                sum += bugs[i];
            }
            if(sum > X * 60 * A + (8 - X) * 60){
                System.out.println(0);
            }else if(sum <= X * 60 * A){
                System.out.println((sum + A - 1) / A);
            }else {
                System.out.println(X * 60 + (sum - X * 60 * A));

            }
        }
    }
}
