package com.example.leedcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.TreeMap;

public class Q347 {
    public static void main(String[] args) {
        List<Integer> integers = new KFrequent().topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2);
        System.out.println(integers);
    }
}

class KFrequent {

    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return map.get(o1) - map.get(o2);//需要最小堆
            }
        });
        for (Integer key : map.keySet()) {
            if (queue.size() < k)
                queue.add(key);
            else {
                if (map.get(key) > map.get(queue.peek())) {
                    queue.poll();
                    queue.add(key);
                }
            }
        }
        LinkedList<Integer> list = new LinkedList<>();
        while (!queue.isEmpty()) {
            list.add(queue.poll());
        }
        return list;
    }

    public List<Integer> topKFrequent2(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        ArrayList[] bucket = new ArrayList[nums.length + 1];
        for (int integer : map.keySet()) {
            int freq = map.get(integer);
            if (bucket[freq] == null)
                bucket[freq] = new ArrayList();
            bucket[freq].add(integer);
        }
        List<Integer> topK = new ArrayList<>();
        for (int i = bucket.length - 1; i >= 0 && topK.size() < k; i--) {
            if(bucket[i] == null)
                continue;
            if(bucket[i].size() < k - topK.size())
                topK.addAll(bucket[i]);
            else {
                topK.addAll(bucket[i].subList(0,k - topK.size()));
            }
        }
        return topK;
    }
}
