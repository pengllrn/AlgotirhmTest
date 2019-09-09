package com.example.test;

/**
 * @author Pengllrn
 * @since <pre>2019/7/5 19:02</pre>
 */
public class Solutionbx {
    public void FindNumsAppearOnce(int [] array,int[] num1 , int[] num2) {
        int diff = 0;
        for(int a : array){
            diff ^= a;
        }
        int x = 1;
        while((diff & x) == 0)
            x <<= 1;
        num1[0] = 0;
        num2[0] = 0;
        for(int a : array){
            if((a & x) == 0)
                num1[0] ^= a;
            else
                num2[0] ^= a;
        }
    }

    public static void main(String[] args) {
        int[] num1 = new int[1];
        int[] num2 = new int[1];
        new Solutionbx().FindNumsAppearOnce(new int[]{2,2,4,1,3,4},num1,num2);
        System.out.println(num1[0]);
        System.out.println(num2[0]);
    }
}
