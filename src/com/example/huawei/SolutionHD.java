package com.example.huawei;

import java.util.AbstractMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;

/**
 * @author Pengllrn
 * @since <pre>2019/6/4 18:47</pre>
 */
//黄岛 逃亡
public class SolutionHD {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        in.close();
        line = line.substring(1,line.length() -1);
        String[] sss = line.split(" ");
        int[] input = new int[sss.length];
        try {
            for (int i = 0; i < sss.length; i++) {
                input[i] = Integer.valueOf(sss[i]);
            }
        }catch (Exception e){
            System.out.print("[-1]");
            return;
        }
        int[] escape = new SolutionHDCore().escape(input);
        System.out.print("[");
        for (int i = 0;i<escape.length - 1;i++){
            System.out.print(escape[i]+" ");
        }
        System.out.print(escape[escape.length -1]);
        System.out.print("]");
    }
}

class SolutionHDCore {
    public int[] escape(int[] input) {
        if (input == null)
            return new int[]{-1};
        int n = input.length;
        LinkedList<Integer> ans = new LinkedList<>();
        LinkedList<Map.Entry<Integer, Integer>> queue = new LinkedList<>();//放正数
        for (int i = 0; i < n; i++) {
            if (input[i] == 0)
                return new int[]{-1};
            else if (input[i] < 0) {
                int rest = input[i];
                while (rest < 0) {
                    if (queue.isEmpty()) {
                        ans.add(i);
                        break;
                    }
                    rest += queue.peekFirst().getValue();
                    if (rest <= 0)
                        queue.removeFirst();
                    else {
                        queue.peekFirst().setValue(rest);
                        break;
                    }
                }
            } else
                queue.addFirst(new AbstractMap.SimpleEntry<>(i, input[i]));
        }
        while (!queue.isEmpty()){
            ans.addLast(queue.removeLast().getKey());
        }
        int[] ret = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            ret[i] = input[ans.get(i)];
        }
        return ret;
    }
}
