package com.example.ieee;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class RemovalGame {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<int[]> arrayList = new ArrayList<>();
        int n = in.nextInt();
        while (n != 0){
            int[] arr = new int[n];
            for (int i = 0;i<n;i++){
                arr[i] = in.nextInt();
            }
            arrayList.add(arr);
            n = in.nextInt();
        }
        ArrayList<Long> results = new Remove().main(arrayList);
        for (Long result : results)
            System.out.println(result);
    }
}

class Remove{

    public ArrayList<Long> main(ArrayList<int[]> arrayList){
        ArrayList<Long> reList = new ArrayList<>();
        for (int i = 0;i<arrayList.size();i++){
            int[] arr = arrayList.get(i);
            reList.add(removeOneArray(arr));
        }
        return reList;
    }

    private long removeOneArray(int[] array){
        LinkedList<Integer> ls = new LinkedList<>();
        for (int i = 0;i<array.length;i++){
            ls.add(array[0]);
        }

        return 0;
    }

    public int getGcd(int m, int n) {//欧几里得算法---求最大公约数
        int t = m % n;
        while (t != 0) {
            m = n;
            n = t;
            t = m % n;
        }
        return n;
    }
}
