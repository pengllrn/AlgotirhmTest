package com.example.leedcode;

import java.util.Arrays;

/**
 * @author Pengllrn
 * @since <pre>2019/6/23 13:45</pre>
 */
public class Q667 {
    public static void main(String[] args) {
        int[] ints = new Solution667().constructArray(2, 1);
        System.out.println(Arrays.toString(ints));
    }
}
//5 1 4 2 3  [4,3,2,1]   或者  1 5 2 4 3   （5，4）
class Solution667{
    public int[] constructArray(int n, int k) {
        if(k < 1 || n <= k)
            return null;
        int[] ans = new int[n];
        int kth = k + 1;
        for (int i = 0,idx = 1;i<n && idx <= kth;idx++){//填[1,k+1]范围
            if(idx == kth){
                ans[i++] = idx;
            }else {
                ans[i++] = idx;
                ans[i++] = kth;
            }
            kth--;
        }
        for (int i = k + 1;i<n;i++){//补全剩余部分[k+2,n]
            ans[i] = i + 1;
        }
        return ans;
    }
}

