package com.example.sort;

import java.util.Arrays;

/**
 * @author Pengllrn
 * @since <pre>2019/6/16 11:00</pre>
 */
public class Test {
    public static void main(String[] args) {
        Integer[] in = new Integer[]{5,3,10,-3,2,439,23,1};
        SelectionSort<Integer> select = new SelectionSort<>();
        select.sort(in);
        System.out.println(Arrays.toString(in));

        Integer[] in1 = new Integer[]{5,3,10,-3,2,439,23,1};
        BubbleSort<Integer> bubble = new BubbleSort<>();
        bubble.sort(in1);
        System.out.println(Arrays.toString(in1));

        Integer[] in2 = new Integer[]{5,3,10,-3,2,439,23,1};
        InsertSort<Integer> insert = new InsertSort<>();
        insert.sort(in2);
        System.out.println(Arrays.toString(in2));

        int[] in3 = new int[]{5,3,10,-3,2,439,23,1};
        InsertSortPlus insertSortPlus = new InsertSortPlus();
        insertSortPlus.sort(in3);
        System.out.println(Arrays.toString(in3));
    }
}
