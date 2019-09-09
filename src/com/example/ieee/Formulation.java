package com.example.ieee;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Formulation {
    public static void main(String[] args) {
        DecimalFormat format = new DecimalFormat("0.00000");
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int x = n / 3;
        int y = x;
        int z = x;
        double result;
        if (x + y + z == n)
            result = Math.sin(x) * 3;
        else if (x + y + z + 1 == n)
            result = Math.sin(x) * 2 + Math.sin(y + 1);
        else {
            double result1 = Math.sin(x) + Math.sin(y + 1) * 2;
            double result2 = Math.sin(x)*2+Math.sin(y+2);
            result = Math.max(result1,result2);
        }
        System.out.println(String.valueOf(result).substring(0,11));
        System.out.println(Math.sin(5)+Math.sin(5)+Math.sin(5));
        for (int i = 1;i<100;i++) {
            System.out.print(format.format(Math.sin(i))+",");
        }
    }
}

class Com{


}