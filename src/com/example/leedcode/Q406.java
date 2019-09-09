package com.example.leedcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Q406 {
    public static void main(String[] args) {
        List<int[]> queue = new ArrayList<>();
    }
}

class ReorderPeople {

    public int[][] reconstructQueue(int[][] people) {
        if (people == null || people.length == 0 || people[0].length == 0)
            return new int[][]{};
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] arr1, int[] arr2) {
                return arr1[0] == arr2[0] ? arr1[1] - arr2[1] : arr2[0] - arr1[0];
            }
        });
        ArrayList<int[]> queue = new ArrayList<>();
        for (int[] p : people){
            queue.add(p[1],p);
        }
        return queue.toArray(new int[queue.size()][]);
    }
}
