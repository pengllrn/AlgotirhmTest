package com.example.bytedance;

import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author Pengllrn
 * @since <pre>2019/7/1 16:33</pre>
 *
 * 21:05
 */
public class Main6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Solution6 solution = new Solution6();
        for (int i = 0; i < N; i++) {
            int M = sc.nextInt();
            int[][] frames = new int[M][];
            for (int j = 0; j < M; j++) {
                int f = sc.nextInt();
                frames[j] = new int[f * 2];
                for (int k = 0; k < f; k++) {
                    frames[j][k * 2] = sc.nextInt();
                    frames[j][k * 2 + 1] = sc.nextInt();
                }
            }
            int ret = solution.longestFeature(frames);
            System.out.println(ret);
        }
    }
}

class Solution6 {
    public int longestFeature(int[][] frames) {
        int n = frames.length;
        Map<Map.Entry<Integer, Integer>, Integer> lastIndex = new HashMap<>();
        Map<Map.Entry<Integer, Integer>, Integer> length = new HashMap<>();
        int max = 0;
        for (int i = 0; i < n; i++) {
            int[] frame = frames[i];
            for (int j = 0; j < frame.length; j += 2) {
                Map.Entry<Integer, Integer> pair = new AbstractMap.SimpleEntry<>(frame[j], frame[j + 1]);
                max = Math.max(max,1);
                if (lastIndex.get(pair) != null && lastIndex.get(pair) == i - 1) {
                    length.put(pair, length.get(pair) + 1);
                    max = Math.max(max,length.get(pair));
                }
                else
                    length.put(pair, 1);
                lastIndex.put(pair, i);
            }
        }
        return max;
    }

}