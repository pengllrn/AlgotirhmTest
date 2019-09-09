package com.example.test;

import java.util.ArrayList;

/**
 * @author Pengllrn
 * @since <pre>2019/7/5 11:37</pre>
 */
public class Solutionhs {
    public int FirstNotRepeatingChar(String str) {
        if(str == null || str.length() == 0)
            return -1;
        int[] cnt = new int[256];
        int[] idx = new int[256];
        for(int i = 0; i < str.length(); i++){
            char c = str.charAt(i);
            cnt[c] ++;
            idx[c] = i;
        }
        ArrayList<Integer> list = new ArrayList<>();//char
        for(int i = 0;i < 256; i++){
            if(cnt[i] == 1) list.add(i);
        }
        int ans = Integer.MAX_VALUE;
        for(Integer i : list){
            ans = Math.min(ans,idx[i]);
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    public static void main(String[] args) {
        int i = new Solutionhs().FirstNotRepeatingChar("hhello");
        System.out.println(i);
    }
}
