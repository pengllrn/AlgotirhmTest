package com.example.wangyi;

import java.util.LinkedHashMap;

/**
 * @author Pengllrn
 * @since <pre>2019/8/4 14:25</pre>
 */
public class MapListTest {
    public static void main(String[] args) {
        LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>(3);
        map.put(3,3);
        map.put(4,4);
        map.put(5,5);
        System.out.println(map.keySet());
        map.get(4);
        map.remove(4);
        map.put(4,4);
        System.out.println(map.keySet());
    }
}
