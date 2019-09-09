package com.example.huawei;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author Pengllrn
 * @since <pre>2019/8/28 20:58</pre>
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] A = new int[n];
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++){
            A[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            map.put(sc.nextInt(), i);
        }
        int[] tails = new int[n];
        int len = 0;
        for (int i = 0; i < n; i++){
            int idx = binarySearch(tails, len, map.get(A[i]));
            tails[idx] = map.get(A[i]);
            if(idx == len)
                len++;
        }
        System.out.println(n - len);
    }

    private static int binarySearch(int[] tails, int len, int key){
        int l = 0, r = len;
        while (l < r){
            int mid = l + (r - l) / 2;
            if(tails[mid] == key)
                return mid;
            else if(tails[mid] > key)
                r = mid;
            else
                l = mid + 1;
        }
        return l;
    }
}
