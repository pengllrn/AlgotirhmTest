package com.example.tx;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(trans(str, 0, str.length()));
    }

    private static int findR(String str, int s){
        int t = 1;
        for (int i = s; i < str.length(); i++){
            char c = str.charAt(i);
            if(c == '['){
                t++;
            }else if(c == ']'){
                --t;
                if(t == 0)
                    return i;
            }
        }
        return s;
    }

    private static String trans(String str, int start, int end){
        StringBuilder sb = new StringBuilder();
        for (int i = start ; i < end; i++){
            char c = str.charAt(i);
            if(c != '['){
                sb.append(c);
            }else {
                int s1 = ++i;//3
                for (; i < end; i++){
                    int R = 0;
                    if(str.charAt(i) == '|'){
                        int num = Integer.valueOf(str.substring(s1, i));//[3,4)
                        R = findR(str, i);
                        String ret = trans(str, i + 1, R);
                        for (int k = 0; k < num; k++){
                            sb.append(ret);
                        }
                        i = R;
                        break;
                    }
                }
            }
        }
        return sb.toString();
    }


}
