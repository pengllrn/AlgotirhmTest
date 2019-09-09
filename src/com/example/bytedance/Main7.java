package com.example.bytedance;

import java.util.Scanner;

/**
 * @author Pengllrn
 * @since <pre>2019/7/1 21:21</pre>
 */
public class Main7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] array = new int[n][n];
        for (int i = 0;i<n;i++){
            for (int j = 0;j<n;j++){
                array[i][j] = sc.nextInt();
            }
        }
        Solution7 solution = new Solution7();
        int i = solution.lowestExpense(array);
        System.out.println(i);

    }
}

class Solution7{
    public int lowestExpense(int[][] array){

        return 0;
    }
}
