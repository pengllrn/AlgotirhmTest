package com.example.test;

/**
 * @author Pengllrn
 * @since <pre>2019/7/5 14:42</pre>
 */
public class Solution372 {
    private int cnt;

    public int InversePairs(int[] array) {
        if (array == null || array.length == 0)
            return 0;
        for (int i = 1; i < array.length; i++) {//2,1
            if (array[i] >= array[i - 1]) continue;
            int p = bs(array, i, array[i]);
            cnt += (i - p);
            move(array,i,p);
        }
        return cnt % 1000000007;
    }

    private int bs(int[] array, int len, int v) {//插入排序
        int left = 0;
        int right = len;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (v < array[mid])
                right = mid;
            else if (v >= array[mid])
                left = mid + 1;
        }
        return left;
    }


    private void move(int[] array, int i, int p) {
        int v = array[i];
        for (; i > p; i--) {
            array[i] = array[i - 1];
        }
        array[p] = v;
    }

    public static void main(String[] args) {
        int i = new Solution372().InversePairs(new int[]{1, 2, 4, 3, 1, 0, 7, 2,2819,31,32134,32141,3135});
        System.out.println(i);
    }
}
