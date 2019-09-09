package com.example.practice;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

import javafx.util.Pair;

/**
 * @author Pengllrn
 * @since <pre>2019/7/30 19:27</pre>
 */
public class TowerG {
    private static int ans;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] Li = new int[N];
        int[] Wi = new int[N];
        sc.nextLine();
        String Ls = sc.nextLine();
        String Ws = sc.nextLine();
        String[] num = Ls.split(" ");
        String[] numW = Ws.split(" ");
        for (int i = 0; i < N; i++){
            Li[i] = Integer.valueOf(num[i]);
        }
        for (int i = 0; i < N; i++){
            Wi[i] = Integer.valueOf(numW[i]);
        }
        ArrayList<Pair<Integer, Integer>> list = new ArrayList<>();
        for (int i = 0; i < N; i++){
            list.add(new Pair<>(Li[i], Wi[i]));
        }
        list.sort((o1, o2) -> o2.getKey() - o1.getKey());
        for (int i = 0; i < list.size(); i++){
            backtrack(list, i, Integer.MAX_VALUE, 1);
        }
        System.out.println(ans);
    }

    private static void backtrack(ArrayList<Pair<Integer, Integer>> list, int i, int W, int h){
        W = Math.min(W - list.get(i).getValue(), list.get(i).getValue() * 7);//剩下可接受容量
        int L = list.get(i).getKey();
        for (int k = i + 1; k < list.size(); k ++){
            if(list.get(k).getKey() == L) continue;
            if(list.get(k).getValue() <= W){
                backtrack(list, k, W, h + 1);
            }
        }
        ans = Math.max(ans, h);
    }
}
