package com.example.leedcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Q455 {
    public static void main(String[] args) {
    }
}

class ContentChildren {

    public int findContentChildren(int[] g, int[] s) {
        if (g == null || s == null)
            return 0;
        Arrays.sort(g);
        Arrays.sort(s);
        int cnt = 0;
        int i = 0;
        int j = 0;
        while (i < g.length && j < s.length) {
            if(s[j] >= g[i]){
                cnt ++;
                j++;
                i++;
            }else
                j++;
        }
        return cnt;
    }
}
