package com.example.xiaomi;

import java.util.Scanner;

/**
 * @author Pengllrn
 * @since <pre>2019/9/6 18:47</pre>
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String arrStr = scanner.nextLine();

        String tempStr = arrStr.substring(1, arrStr.length() - 1);
        String[] tempStrArr = tempStr.split(",");
        int[] nums = new int[tempStrArr.length];
        for (int i = 0; i < tempStrArr.length; i++) {
            nums[i] = Integer.parseInt(tempStrArr[i]);
        }

        int len=maxDistToClosest(nums);
        System.out.println(len);
    }

    public static int maxDistToClosest(int[] seats) {
        int n = seats.length;
        int lCnt = 0;
        int rCnt = 0;
        int i = 0;
        int j = n - 1;
        while (i < n && seats[i++] == 0) lCnt++;
        while (j >= 0 && seats[j--] == 0) rCnt++;
        int max = 1, prev = 0;
        for (int k = i; k <= j; k++) {
            if(seats[k] == 0) prev++;
            else prev = 0;
            max = Math.max(max, prev);
        }
        int res = Math.max((max + 1) / 2, Math.max(lCnt, rCnt));
        return res;
    }
}
