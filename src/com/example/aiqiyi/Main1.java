package com.example.aiqiyi;
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        int z = sc.nextInt();
        int k = sc.nextInt();

        long curX = 1;
        long curY = 1;
        long curZ = 1;
        long cur = 1;
        for (int i = 1; i <= Math.min(x + y + z, k); i++) {
            if (curX < x) {
                cur = Math.max(cur, (curX + 1) * curY * curZ);
            }
            if (curY < y) {
                cur = Math.max(cur, curX * (curY + 1) * curZ);
            }
            if (curZ < z) {
                cur = Math.max(cur, curX * curY * (curZ + 1));
            }
            if (curX < x && cur == (curX + 1) * curY * curZ) {
                curX++;
            } else if (curY < y && curX * (curY + 1) * curZ == cur)
                curY++;
            else if (curZ < z && cur == curX * curY * (curZ + 1))
                curZ++;
        }
        System.out.println(cur);
    }
}