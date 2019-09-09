package com.example.bytedance;

import java.util.Scanner;


/**
 * 1. 三个同样的字母连在一起，一定是拼写错误，去掉一个的就好啦：比如 helllo -> hello
 * 2. 两对一样的字母（AABB型）连在一起，一定是拼写错误，去掉第二对的一个字母就好啦：比如 helloo -> hello
 */
public class Main3{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String[] strs = new String[N];
        for (int i = 0; i < N; i++) {
            strs[i] = sc.next();
        }
        sc.close();
        Solution3 solution = new Solution3();
        for(String s : strs){
            System.out.println(solution.solve(s));
        }
    }
}

class Solution3 {
    public String solve(String s) {
        if (s.length() < 3) return s;
        if (s.length() < 4 && ((s.charAt(0) == s.charAt(1)) && (s.charAt(1) == s.charAt(2))))
            return delete(s, 2);
        for (int i = 0; i < s.length() - 3; i++) {
            if ((s.charAt(i) == s.charAt(i + 1)) && (s.charAt(i + 1) == s.charAt(i + 2))) {//AABB
                s = delete(s, i);
                i--;
            } else if ((s.charAt(i) == s.charAt(i + 1)) && (s.charAt(i + 2) == s.charAt(i + 3))) {//AAA
                s = delete(s, i + 3);
                i--;
            }
        }
        char c = s.charAt(s.length() - 2);
        if (((s.charAt(s.length() - 3) == c) && (c == s.charAt(s.length() - 1))))
            s = delete(s, s.length() - 1);
        return s;
    }

    private String delete(String s, int a) {
        StringBuilder s2 = new StringBuilder();
        for (int i = 0; i < a; i++) {
            s2.append(s.charAt(i));
        }
        for (int i = a + 1; i < s.length(); i++) {
            s2.append(s.charAt(i));
        }
        return s2.toString();
    }
}