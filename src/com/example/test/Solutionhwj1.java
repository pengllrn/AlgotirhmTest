package com.example.test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @author Pengllrn
 * @since <pre>2019/7/4 20:41</pre>
 */
public class Solutionhwj1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 0; i < T;i++){
            int n = sc.nextInt();
            int v;
            int len = 0;
            int ans = 0;
            int tmp = 0;
            for (int j = 0; j < n; j++){
                v = sc.nextInt();
                if(tmp < 0) tmp = 0;
                tmp += v;
                if(tmp >= ans){
                    ans = tmp;
                    len++;
                }
            }
        }
        String[] s = new String[]{};
        Arrays.sort(s, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o1 + o2).compareTo(o2 + o1);
            }
        });
    }

}
