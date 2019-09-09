package com.example.test.t71;

import java.util.Scanner;

/**
 * @author Pengllrn
 * @since <pre>2019/7/1 13:35</pre>
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String[] strings = new String[N];
        for (int i = 0; i < N; i++) {
            strings[i] = sc.next();
        }
        Solution1 solution = new Solution1();
        for (String str : strings)
            System.out.println(solution.solve(str));

    }

}

class Solution1 {
    public String solve(String s) {
        if (s == null || s.length() <= 2) return s;
        for (int i = 0; i < s.length() - 3; i++) {
            if (s.charAt(i) == s.charAt(i + 1) && s.charAt(i + 2) == s.charAt(i + 3)) {//AABB
                s = delete(s, i + 2);
                i--;
            }
            else if(s.charAt(i) == s.charAt(i + 1) && s.charAt(i) == s.charAt(i + 2)){//AAA
                s = delete(s,i);
                i--;
            }
        }
        int n = s.length();
        if(s.charAt(n - 1) == s.charAt(n - 2) && s.charAt(n - 1) == s.charAt(n - 3))//可能结尾剩余3个AAA的情况
            s = delete(s,n-1);
        return s;
    }

    private String delete(String s, int i) {
        return s.substring(0, i) + s.substring(i + 1);
    }
}