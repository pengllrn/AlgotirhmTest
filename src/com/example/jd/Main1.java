package com.example.jd;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String str = sc.next();
        int cnt = 0;
        boolean prev = false;
        for (int i = 0; i < n; i++){
            char c= str.charAt(i);
            boolean cur = isUpper(c);
            if(prev == cur) cnt++;
            else {
                cnt += 2;
                if(i != 0 && isUpper(str.charAt(i - 1)) == cur){
                    cnt--;
                    prev = !prev;
                }
            }
        }
        System.out.println(cnt);
    }

    private static boolean isUpper(char c){
        return c >= 'A' && c <= 'Z';
    }
}
