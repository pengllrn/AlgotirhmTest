package com.example.leedcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Q763 {
    public static void main(String[] args) {
        List<Integer> integers = new PartitionString().partitionLabels2("ababcbacadefegdehijhklij");
        System.out.println(integers);
    }
}

class PartitionString {

    public List<Integer> partitionLabels(String s) {
        List<Integer> list = new ArrayList<>();
        if (s == null || s.length() == 0)
            return list;
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }
        int cnt = 0;
        Set<Character> set = new HashSet<>();
        Character cur = null;
        for (char c : s.toCharArray()) {
            if (cur == null)
                cur = c;
            set.add(c);
            freq[c - 'a']--;
            cnt++;
            if (c == cur && freq[cur - 'a'] == 0) {
                while (cur != null && freq[cur - 'a'] == 0) {
                    set.remove(cur);
                    if (set.iterator().hasNext())
                        cur = set.iterator().next();
                    else
                        cur = null;
                }
                if (set.isEmpty()) {
                    list.add(cnt);
                    cnt = 0;//重置计数器
                }
            }
        }
        return list;
    }

    public List<Integer> partitionLabels2(String s) {
        List<Integer> list = new ArrayList<>();
        if (s == null || s.length() == 0)
            return list;
        int[] lastIndexOfChar = new int[26];
        for (int i = 0; i < s.length(); i++) {
            lastIndexOfChar[s.charAt(i) - 'a'] = i;
        }
        int firstIndex = 0;
        while (firstIndex < s.length()) {
            int lastIndex = firstIndex;
            for (int i = firstIndex; i <= lastIndex; i++) {
                int index = lastIndexOfChar[s.charAt(i) - 'a'];
                if (index > lastIndex) {//在这个范围内出现了更大的lastIndex，则进行更新
                    lastIndex = index;
                }
            }
            list.add(lastIndex - firstIndex + 1);
            firstIndex = lastIndex + 1;
        }
        return list;
    }
}