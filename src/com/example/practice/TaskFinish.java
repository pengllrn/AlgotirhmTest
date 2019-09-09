package com.example.practice;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @author Pengllrn
 * @since <pre>2019/7/30 16:15</pre>
 */
public class TaskFinish {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] time = new int[N];
        ArrayList<Integer>[] depend = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            time[i] = sc.nextInt();
            depend[i] = new ArrayList<>();
        }
        int[] count = new int[N];//每个任务的依赖数
        for (int i = 0; i < M; i++) {
            int A = sc.nextInt();
            int B = sc.nextInt();
            count[A]++;
            depend[B].add(A);
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.comparingInt(o -> time[o]));
        for (int i = 0; i < N; i++){//放入可执行任务
            if(count[i] == 0)
                queue.add(i);
        }
        long ans = 0;
        System.out.println();
        while (!queue.isEmpty()){
            int taskId = queue.poll();
            ans += (ans + time[taskId]);
            System.out.print(taskId + " ");
            updateDepend(depend[taskId], queue, count);//更新可执行任务
        }
        System.out.println(ans);
    }

    private static void updateDepend(ArrayList<Integer> depend, PriorityQueue<Integer> queue,int[] count) {
        for (Integer task : depend) {
            if(--count[task] == 0){
                queue.add(task);
            }
        }
    }
}
