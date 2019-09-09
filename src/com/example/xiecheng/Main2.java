package com.example.xiecheng;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * @author Pengllrn
 * @since <pre>2019/9/4 19:48</pre>
 */
public class Main2 {

    static String resolve(String expr) {
        LinkedList<Character> stack = new LinkedList<>();
        boolean flag;
        for (int i = 0; i < expr.length(); i++) {
            char c = expr.charAt(i);
            if(c == ')') {
                flag = false;
                StringBuilder tmp = new StringBuilder();
                while (!stack.isEmpty()){
                    if(stack.peekLast() == '(') {
                        stack.removeLast();
                        for(char cc : tmp.toString().toCharArray()){
                            stack.addLast(cc);
                        }
                        flag = true;
                        break;
                    }
                    tmp.append(stack.removeLast());
                }
                if (!flag) return "";
            }else
                stack.add(c);
        }
        StringBuilder res = new StringBuilder();
        while (!stack.isEmpty()) {
            char c = stack.removeFirst();
            if(c == '(') return "";
            res.append(c);
        }
        return res.toString();
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String res;

        String _expr;
        try {
            _expr = in.nextLine();
        } catch (Exception e) {
            _expr = null;
        }

        res = resolve(_expr);
        System.out.println(res);
    }
}