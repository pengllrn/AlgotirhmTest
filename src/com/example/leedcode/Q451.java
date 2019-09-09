package com.example.leedcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Q451 {
    public static void main(String[] args) {
        String teer = new ResortString().frequencySort("aba");
        System.out.println(teer);
    }
}

class ResortString {

    public String frequencySort(String s) {
        if (s == null || s.length() == 0)
            return "";
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        ArrayList<Character> arrayList = new ArrayList<>();
        arrayList.addAll(map.keySet());
        arrayList.sort(new Comparator<Character>() {
            @Override
            public int compare(Character o1, Character o2) {
                return map.get(o2) - map.get(o1);
            }
        });
        StringBuilder sb = new StringBuilder();
        for (Character c : arrayList){
            for (int i = 0;i<map.get(c);i++){
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
