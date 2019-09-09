package com.example.wangyi;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @author Pengllrn
 * @since <pre>2019/8/4 9:35</pre>
 */
public class OldEvenExchange {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int old = 0, even = 0;
        Integer[] a = new Integer[n];
        for (int i = 0; i < n; i++){
            a[i] = sc.nextInt();
            if((a[i] & 1) == 0)
                even++;
            else
                old++;
        }
        if(old > 0 && even > 0){
            Arrays.sort(a, new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return Integer.valueOf(o1 + "" + o2) - Integer.valueOf(o2 + "" + o1);
                }
            });
        }
        for (int i = 0; i < n; i++){
            System.out.print(a[i] + " ");
        }
    }
}
