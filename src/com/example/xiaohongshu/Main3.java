package com.example.xiaohongshu;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * @author Pengllrn
 * @since <pre>2019/9/3 20:33</pre>
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        LinkedList<Character> stack = new LinkedList<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if(c == '<') {
                if (stack.isEmpty() || stack.peekFirst() == '(') continue;
                stack.removeFirst();
            }else if(c == ')') {
                while (!stack.isEmpty() && stack.removeFirst() != '(');
            }else
                stack.addFirst(c);
        }
        while (!stack.isEmpty()){
            System.out.print(stack.removeLast());
        }
    }
}
