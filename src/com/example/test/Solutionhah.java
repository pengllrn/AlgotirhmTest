package com.example.test;

import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

import javax.swing.text.html.parser.Entity;

/**
 * @author Pengllrn
 * @since <pre>2019/7/6 14:36</pre>
 */
public class Solutionhah {
    public boolean duplicate(int[] numbers,int length,int [] duplication) {
        if(numbers == null || numbers.length == 0 || length != numbers.length)
            return false;
        for(int i = 0; i < length; i++){
            while(i != numbers[i]){
                if(numbers[i] == numbers[numbers[i]]){
                    duplication[0] = numbers[i];
                    return true;
                }
                int tmp = numbers[i];//i=0  tmp = 2
                numbers[i] = numbers[numbers[i]];
                numbers[tmp] = tmp;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] dup = new int[1];
        boolean duplicate = new Solutionhah().duplicate(new int[]{2, 3, 1, 0, 2, 5, 3}, 7, dup);
        System.out.println(dup[0]);
    }
}
