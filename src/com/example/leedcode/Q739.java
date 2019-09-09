package com.example.leedcode;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author Pengllrn
 * @since <pre>2019/6/20 12:20</pre>
 */
public class Q739 {
    public static void main(String[] args) {
        Solution739 solution739 = new Solution739();
        int[] ints = solution739.dailyTemperatures(new int[]{73,28,38,29});
        System.out.println(Arrays.toString(ints));
    }
}

class Solution739 {
    public int[] dailyTemperatures(int[] T) {
        if (T == null || T.length == 0)
            return null;
        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[T.length];
        for (int i = 0; i < T.length; i++) {
            int cur = T[i];
            if (stack.isEmpty() || cur <= stack.peek()) {
                stack.push(cur);
                continue;
            }
            int j = 0;
            int t = i;
            while (!stack.isEmpty() && stack.peek() < cur) {
                stack.pop();
                while (--t >= 0) {
                    j++;
                    if (ans[t] != 0) continue;
                    ans[t] = j;
                    break;
                }
            }
            stack.push(cur);
        }
        return ans;
    }
}

class Solution739_2{
    public int[] dailyTemperatures(int[] T) {
        if (T == null || T.length == 0)
            return null;
        int n = T.length;
        int[] ans = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int curIndex = 0;curIndex < n;curIndex++){
            while (!stack.isEmpty() && T[curIndex] > T[stack.peek()]){
                int preIndex = stack.pop();
                ans[preIndex] = curIndex - preIndex;
            }
            stack.add(curIndex);
        }
        return ans;
    }
}
