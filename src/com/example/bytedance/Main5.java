package com.example.bytedance;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author Pengllrn
 * @since <pre>2019/7/1 14:20</pre>
 */
public class Main5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[13];
        for (int i = 0; i < 13; i++) {
            arr[i] = sc.nextInt();
        }
        sc.close();
        Solution5 solution = new Solution5();
        List<Integer> result = solution.result(arr);
        if (result.size() == 0)
            System.out.println(0);
        else {
            for (Integer re : result)
                System.out.print(re + " ");
        }
    }
}

class Solution5 {
    public List<Integer> result(int[] nums) {
        int[] cnt = new int[10];
        List<Integer> ans = new ArrayList<>();
        for (int i : nums) cnt[i]++;
        for (int i = 1; i <= 9; i++) {//插入的数
            if (cnt[i] == 4)//不能再插入这个数了
                continue;
            cnt[i]++;//插入i
            if (canWin(cnt)) ans.add(i);
            cnt[i]--;
        }
        return ans;
    }

    private boolean canWin(int[] cnt) {
        for (int i = 1; i <= 9; i++) {//以i为雀头
            if (cnt[i] <= 1)
                continue;
            cnt[i] -= 2;//减少雀头的两张牌
            boolean judge = judge(cnt);
            cnt[i] += 2;
            if (judge) return true;
        }
        return false;
    }

    private boolean judge(int[] cnt) {//判断该序列可否胡
        int[] bp = Arrays.copyOf(cnt, cnt.length);
        for (int i = 1; i <= 9; i++) {
            if (bp[i] == 4)
                bp[i] -= 3;
            if (bp[i] == 3 || bp[i] == 0)
                continue;
            if (bp[i] <= 0 || i > 7)
                return false;
            bp[i + 1] -= bp[i];
            bp[i + 2] -= bp[i];
        }
        return true;
    }
}
