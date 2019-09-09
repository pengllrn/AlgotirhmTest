package com.example.hd;

import java.util.Scanner;

/**
 * @author Pengllrn
 * @since <pre>2019/8/26 19:00</pre>
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int n = str.length();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n / 3; i++){
            StringBuilder tmp = new StringBuilder();
            for (int j = 0; j < 3; j++){
                tmp.append(bin(str.charAt(i * 3 + j)));
            }
            String tp = tmp.toString();
            for (int j = 0; j < 4; j++){
                sb.append(map(out(tp.substring(j * 6, (j + 1) * 6))));
            }
        }
        int start = n / 3 * 3;
        int rest = n - start;
        if(rest > 0){
            StringBuilder tmp = new StringBuilder();
            for (int k = 0; k < 3; k++){
                if(k < rest) tmp.append(bin(str.charAt(start++)));
                else tmp.append("00000000");
            }
            String tp = tmp.toString();
            for (int j = 0; j < 4; j++){
                int out = out(tp.substring(j * 6, (j + 1) * 6));
                if(out == 0) break;
                sb.append(map(out));
            }
            for (int i = 0; i < 3 - rest; i++)
                sb.append("=");
        }
        System.out.println(sb.toString());
    }

    private static int out(String s){
        int n = 0;
        for (char c : s.toCharArray()){
            n = (n << 1) + (c - '0');
        }
        return n;
    }

    private static String bin(int num){
        String s = Integer.toBinaryString(num);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 8 - s.length(); i++){
            sb.append("0");
        }
        sb.append(s);
        return sb.toString();
    }

    private static char map(int idx){
        int v;
        if(idx < 26) v = 'A' + idx;
        else if(idx < 52) v = 'a' + idx - 26;
        else if(idx < 62) v = '0' + idx - 52;
        else if(idx == 62) v = '+';
        else v = '/';
        return (char) v;
    }
}
