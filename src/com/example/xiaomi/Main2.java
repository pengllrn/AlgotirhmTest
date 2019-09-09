package com.example.xiaomi;
import java.util.Scanner;
import java.util.Arrays;


public class Main2{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String arrStr = scanner.nextLine();

        String tempStr = arrStr.substring(1, arrStr.length() - 1);
        String[] tempStrArr = tempStr.split(",");
        int[] ratings = new int[tempStrArr.length];
        for (int i = 0; i < tempStrArr.length; i++) {
            ratings[i] = Integer.parseInt(tempStrArr[i]);
        }

        int candynum=candy(ratings);
        System.out.println(candynum);

    }
    public static int candy(int[] ratings) {
        int n = ratings.length;
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            if(ratings[i] > ratings[i - 1])
                dp[i] = dp[i - 1] + 1;
//            else if(ratings[i] == ratings[i - 1])
//                dp[i] = dp[i - 1];
            else dp[i] = 1;
        }
        for (int i = n - 2; i >= 0; i--) {
            if(ratings[i] > ratings[i + 1])
                dp[i] = Math.max(dp[i], dp[i + 1] + 1);
            else if(ratings[i] == ratings[i + 1])
                dp[i] = Math.max(dp[i], dp[i + 1]);
        }
//        System.out.println(Arrays.toString(dp));
        int total = 0;
        for (int d : dp){
            total += d;
        }
        return total;
    }
}
