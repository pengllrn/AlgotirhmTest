package com.example.bytedance;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author Pengllrn
 * @since <pre>2019/8/25 20:19</pre>
 */
public class Main10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] cmu = new int[N][N];
        for (int i = 0; i < N; i++){
            for (int j = 0; j < N; j++) {
                cmu[i][j] = sc.nextInt();
            }
        }
        boolean[] marked = new boolean[N];
        int cnt = 0;
        for (int i = 0; i < N; i++){
            if(marked[i]) continue;
            cnt++;
            Stack<Integer> stack = new Stack<>();
            stack.push(i);
            marked[i] = true;
            while (!stack.isEmpty()){
                int size = stack.size();
                while (size-- > 0){
                    int idx = stack.pop();
                    for (int j = idx + 1; j < N; j++){
                        if(cmu[idx][j] < 3 || marked[j]) continue;
                        stack.push(j);
                        marked[j] = true;
                    }
                }
            }
        }
        System.out.println(cnt);
    }
}
