package com.example.huawei;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 * @author Pengllrn
 * @since <pre>2019/8/21 19:45</pre>
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String from = sc.next();
        int n = sc.nextInt();
        sc.nextLine();
        Set<String>[] array = new Set[n];
        int[] circle = new int[n];
        for (int i = 0; i < n; i++){
            circle[i] = i;
            String line = sc.nextLine();
            String[] names = line.split(" ");
            array[i] = new HashSet<>(Arrays.asList(names));
        }
        int loc = n;
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++){
            Set<String> set = array[i];
            if(set.contains(from)){
                loc = Math.min(loc, circle[i]);
            }
            for (String name : set){
                if(!map.containsKey(name)){
                    map.put(name, circle[i]);
                }else {
                    Integer wh = map.get(name);
                    while (wh != circle[wh]){
                        wh = circle[wh];
                    }
                    for (int k = 0; k <= i; k++){
                        if(circle[k] == circle[i]){
                            if(loc == circle[k]) loc = wh;
                            circle[k] = wh;
                        }
                    }
                }
            }
        }
        Set<String> res = new HashSet<>();
        for (int i = 0; i < n; i++){
            if(circle[i] == loc){
                res.addAll(array[i]);
            }
        }
        System.out.println(res.size());
    }
}
