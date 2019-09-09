package com.example.main;

import java.util.Scanner;

/**
 * @author Pengllrn
 * @since <pre>2019/7/28 15:04</pre>
 */
public class Main1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line1 = sc.nextLine();
        String[] numbers = line1.split(" ");
        int[] array = new int[numbers.length];
        for(int i = 0; i < numbers.length; i++){
            array[i] = Integer.valueOf(numbers[i]);
        }
        String line2 = sc.nextLine();
        numbers = line2.split(" ");
        int[] select = new int[numbers.length];
        for (int i = 0; i < numbers.length; i++){
            select[i] = Integer.valueOf(numbers[i]);
        }
        //find disorder index
        int error = 0;
        for (int i = 1; i < array.length; i++){
            if(array[i] <= array[i - 1]){
                error = i;
                break;
            }
        }
        //error - 1, error
        int left = array[error - 1] + 1;
        int right = error == array.length - 1 ? Integer.MAX_VALUE : array[error + 1] - 1;
        Integer R = findOn(select, left, right);
        if(R != null){
            array[error] = R;
            print(array);
            return;
        }
        error = error - 1;
        left = error == 0 ? -Integer.MIN_VALUE : array[error - 1] + 1;
        right = array[error + 1] - 1;
        Integer L = findOn(select, left, right);
        if(L != null){
            array[error] = L;
            print(array);
            return;
        }
        System.out.println("NO");
    }
    private static Integer findOn(int[] select, int min, int max){
        Integer ret = - Integer.MIN_VALUE;
        for (int s : select){
            if(s >= min && s <= max){
                ret = Math.max(ret, s);
            }
        }
        return ret == - Integer.MIN_VALUE ? null : ret;
    }

    private static void print(int[] array){
        for (int a : array){
            System.out.print(a + " ");
        }
    }
}
