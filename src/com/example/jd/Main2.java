package com.example.jd;

import java.util.Scanner;

/**
 * @author Pengllrn
 * @since <pre>2019/8/24 20:08</pre>
 */
public class Main2 {
    private static int[][] direction = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    private static int min = 25;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] arr = new int[5][5];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        int[][] cnt = new int[5][5];
        for (int i = 0; i < 5; i++){
            for (int j = 0; j < 5; j++){
                cnt[i][j] = count(arr, i ,j);
            }
        }
    }

    private static int count(int[][] nums, int i, int j){
        int cnt  = 0;
        for (int[] d : direction){
            int ni = i + d[0], nj =j + d[1];
            if(ni < 0 || ni == 5 || nj < 0 || nj == 5)
                continue;
            if(nums[ni][nj] == nums[i][j]) cnt++;
        }
        return cnt;

    }

    private static void drop(int[][] nums) {
        for (int i = 0; i < 5; i++) {
            int k = 4;
            for (int j = 4; j>= 0; j--){
                if(nums[i][j] != 0){
                    nums[i][k--] = nums[i][j];
                }
            }
            for (; k >= 0; k--){
                nums[i][k] = 0;
            }
        }
    }
}
