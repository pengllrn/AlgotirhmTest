package com.example.leedcode;

import java.util.ArrayList;
import java.util.List;

public class Q241 {
    public static void main(String[] args) {
        List<Integer> integers = new Solution241().diffWaysToCompute("21-1-1");
        System.out.println(integers);
    }
}

/**
 * 12:43
 */
class Solution241 {

    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> list = new ArrayList<>();
        if (input == null || input.length() == 0) {
            return list;
        }
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if(c == '+' || c == '-' || c == '*'){
                List<Integer> left = diffWaysToCompute(input.substring(0, i));
                List<Integer> right = diffWaysToCompute(input.substring(i+1));
                for (int l : left)
                    for (int r : right) {
                        switch (c) {
                            case '+':
                                list.add(l + r);
                                break;
                            case '-':
                                list.add(l - r);
                                break;
                            case '*':
                                list.add(l * r);
                                break;
                        }
                    }
            }
        }
        if (list.size() == 0)
            list.add(Integer.valueOf(input));
        return list;
    }


}


