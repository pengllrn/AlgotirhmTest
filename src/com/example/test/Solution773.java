package com.example.test;

/**
 * @author Pengllrn
 * @since <pre>2019/7/5 9:52</pre>
 */
public class Solution773 {
    public int GetUglyNumber_Solution(int index) {
        if(index <= 6)
            return index > 0 ? index : 0;
        int cnt = 6;
        int next = 0;
        int p2 = 3, p3 = 2, p5 = 1;
        while(cnt < index){
            next = Math.min((p2 + 1) * 2, Math.min((p3 + 1) * 3, (p5 + 1) * 5));
            if(next % 2 == 0) p2++;
            if(next % 3 == 0) p3++;
            if(next % 5 == 0) p5++;
            cnt++;
        }
        return next;
    }

    public static void main(String[] args) {
        int i = new Solution773().GetUglyNumber_Solution(11);
        System.out.println(i);
    }
}
