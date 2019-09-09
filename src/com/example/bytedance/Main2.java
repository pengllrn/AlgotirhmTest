package com.example.bytedance;

import java.util.Scanner;

/**
 * @author Pengllrn
 * @since <pre>2019/6/30 22:45</pre>
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] scores = new int[n];
        for (int i = 0; i < n; i++) {
            scores[i] = in.nextInt();
        }
        in.close();
        int i = new Solution2().minSauce(scores);
        System.out.println(i);
    }
}

/**
 * 5
 * 80 90 90 60 1
 */
class Solution2 {

    public int minSauce(int[] scores) {
        int[] result = new int[scores.length];
        int start = 0;
        int cur = 1;
        result[0] = cur;
        for (int i = 1; i < scores.length; i++) {
            if (scores[i] > scores[i - 1]) {
                result[i] = ++cur;
                start = i;
            } else if (scores[i] == scores[i - 1])
                result[i] = cur;
            else {
                reallocate(result, scores,start, i);
                cur = 1;
            }
        }

        int sum = 0;
        for (int i : result)  sum += i;
        return sum;
    }

    private void reallocate(int[] alloate, int[] scores,int start, int k) {
        int idx = 1;
        for (int i = k; i >= start; i--) {
            alloate[i] = Math.max(idx,alloate[i]);
            if(i > start && scores[i - 1] > scores[i])
                idx++;
        }
    }

}
