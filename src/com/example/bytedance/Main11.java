package com.example.bytedance;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Pengllrn
 * @since <pre>2019/8/25 20:33</pre>
 */
public class Main11 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int orientation = sc.nextInt();
        int[][] nums = new int[4][4];
        for (int i = 0; i < 4; i++){
            for (int j = 0; j < 4; j++) {
                nums[i][j] = sc.nextInt();
            }
        }
        if(orientation == 1){
            up(nums);
        }else if(orientation == 2)
            down(nums);
        else if(orientation == 3){
            left(nums);
        }else {
            right(nums);
        }

        for (int i = 0; i < 4; i++){
            System.out.println(Arrays.toString(nums[i]));
        }
    }

    private static void up(int[][] nums){
        for (int i = 0; i < 4; i++) {//列
            int idx = 0;
            for (int j = 0; j < 4; j++) {//行
                if(nums[j][i] == 0) continue;
                if(j < 3 && nums[j][i] == nums[j + 1][i]) {
                    nums[idx++][i] = nums[j][i] + nums[j + 1][i];
                    j++;
                }
                else
                    nums[idx++][i] = nums[j][i];
            }
            while (idx < 4)
                nums[idx++][i] = 0;
        }
    }

    private static void down(int[][] nums){
        for (int i = 0; i < 4; i++) {//行
            int idx = 3;
            for (int j = 3; j >= 0; j--) {//列
                if(nums[j][i] == 0) continue;
                if(j > 0 && nums[j][i] == nums[j - 1][i]) {
                    nums[idx--][i] = nums[j][i] + nums[j - 1][i];
                    j--;
                }
                else
                    nums[idx--][i] = nums[j][i];
            }
            while (idx >= 0)
                nums[idx--][i] = 0;
        }
    }

    private static void left(int[][] nums){
        for (int i = 0; i < 4; i++) {//行
            int idx = 0;
            for (int j = 0; j < 4; j++) {//列
                if(nums[i][j] == 0) continue;
                if(j < 3 && nums[i][j] == nums[i][j + 1]) {
                    nums[i][idx++] = nums[i][j] + nums[i][j + 1];
                    j++;
                }
                else
                    nums[i][idx++] = nums[i][j];
            }
            while (idx < 4)
                nums[i][idx++] = 0;
        }
    }

    private static void right(int[][] nums){
        for (int i = 0; i < 4; i++) {//行
            int idx = 3;
            for (int j = 3; j >= 0; j--) {//列
                if(nums[i][j] == 0) continue;
                if(j > 0 && nums[i][j] == nums[i][j - 1]) {
                    nums[i][idx--] = nums[i][j] + nums[i][j - 1];
                    j--;
                }
                else
                    nums[i][idx--] = nums[i][j];
            }
            while (idx >= 0)
                nums[i][idx--] = 0;
        }
    }


}

/**
 4
 2 0 0 2
 2 2 4 4
 2 4 2 8
 2 2 2 8

 */