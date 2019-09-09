package com.example.bytedance;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author Pengllrn
 * @since <pre>2019/8/25 19:52</pre>
 */
public class Main9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        boolean[] marked = new boolean[n];
        int max = 0;
        for (int i = 0; i < n; i++){
            int cur = 0;
            if(marked[i]) continue;
            Stack<Pair> stack = new Stack<>();
            stack.push(new Pair(a[i], i));
            marked[i] = true;
            while (!stack.isEmpty()){
                int size = stack.size();
                cur += size;
                while (size-- > 0){
                    Pair pair = stack.pop();
                    for (int j = 1; j < n; j++){
                        if(marked[j] || gcd(pair.val, a[j]) <= 1) continue;
                        stack.push(new Pair(a[j], j));
                        marked[j] = true;
                    }
                }
            }
            max = Math.max(max, cur);
        }
        System.out.println(max);
    }

    private static int gcd(int a, int b){
        if(b == 0) return a;
        else return gcd(b, a % b);
    }

    static class Pair {
        int val ;
        int idx;
        public Pair(int val, int idx){
            this.val = val;
            this.idx = idx;
        }
    }
}
