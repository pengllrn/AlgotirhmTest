package com.example.ieee;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Map;
import java.util.Scanner;

public class GrilleDecrypted {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        ArrayList<Map.Entry<Integer, Integer>> holes = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String line = in.next();
            for (int j = 0; j < n; j++) {
                if (line.charAt(j) == '.') {
                    holes.add(new AbstractMap.SimpleEntry<>(i, j));
                }
            }
        }
        String encrypted = in.next();
        String decrypted = new Grille().decrypted(encrypted, holes, n);
        System.out.println(decrypted);
    }
}


class Grille {
    private int n;
    private int count = 0;

    public String decrypted(String encrypt, ArrayList holes, int n) {
        if (n <= 0 || n * n != encrypt.length())
            return "invalid grille";
        if (n == 1)
            return holes.size() > 0 ? encrypt : "invalid grille";
        this.n = n;
        Character[][] result = new Character[n][n];
        input(result, holes, encrypt);
        for (int i = 0; i < 3 && count < n*n; i++) {
            holes = rotate(holes);
            input(result, holes, encrypt);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (result[i][j] == null)
                    break;
                sb.append(result[i][j]);
            }
        }
        return sb.toString();
    }

    private ArrayList<Map.Entry<Integer, Integer>> rotate(ArrayList<Map.Entry<Integer, Integer>> holes) {
        ArrayList<Map.Entry<Integer, Integer>> rtList = new ArrayList<>();
        for (Map.Entry<Integer, Integer> hole : holes) {
            int i = hole.getKey();
            int j = hole.getValue();
            int temp = i;
            i = j;
            j = n - 1 - temp;
            rtList.add(new AbstractMap.SimpleEntry<>(i, j));
        }
        return rtList;
    }

    private void input(Character[][] result, ArrayList<Map.Entry<Integer, Integer>> holes, String encrypt) {
        holes.sort(Comparator.comparingInt(Map.Entry::getValue));
        holes.sort(Comparator.comparingInt(Map.Entry::getKey));
        for (Map.Entry<Integer, Integer> hole : holes) {
            int i = hole.getKey();
            int j = hole.getValue();
            if (result[i][j] != null)
                continue;
            if(count >= encrypt.length())
                break;
            result[i][j] = encrypt.charAt(count++);
        }
    }
}