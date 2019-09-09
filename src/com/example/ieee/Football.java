package com.example.ieee;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Football {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Queue<String> queueNames = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            queueNames.add(in.next());
        }
        String records = in.next();
        char[] recordsArray = records.toCharArray();

        Deque<String> queueW = new LinkedList<>();//W
        Deque<String> queueB = new LinkedList<>();//B
        Queue<String> queueResult = new LinkedList<>();
        int cntW = 0, cntB = 0, cntResult = 0;
        boolean curW = true;
        boolean curB = true;
        //初始化
        queueW.add(queueNames.poll());
        queueB.add(queueNames.poll());
        queueW.addFirst(queueNames.poll());
        queueB.addFirst(queueNames.poll());
        cntB = 1;
        cntW = 1;
        for (int i = 0;i<recordsArray.length;i++) {//n轮比赛
            char cur = recordsArray[i];
            if (cur == 'W') {
                queueW.addLast(queueW.poll());//交换位置
                curW = !curW;
                cntW++;
                String tmp = queueB.pollFirst();
                if (cntB >= cntResult && cntB>=cntW) {
                    if (cntB > cntResult)//有更大的记录
                        queueResult.clear();
                    queueResult.add(curB ? (queueB.peek() + " " + tmp) : (tmp + " " + queueB.peek()));
                    cntResult = cntB;
                }
                queueNames.add(tmp);
                queueB.addLast(queueNames.poll());
                cntB = 1;
                curB = false;
            } else {
                queueB.addLast(queueB.pollFirst());//交换位置
                curB = !curB;
                cntB++;
                String tmp = queueW.pollFirst();
                if(cntW >= cntResult && cntW>=cntB){
                    if (cntW > cntResult && queueResult.size() > 0)
                        queueResult.clear();
                    queueResult.add(curW ? (queueW.peek() +" "+ tmp) : (tmp + " "+queueW.peek()));
                    cntResult = cntW;
                }
                queueNames.add(tmp);
                queueW.addLast(queueNames.poll());
                cntW = 1;
                curW = false;
            }
            if(i != recordsArray.length-1)
                continue;
            if (cntB >= cntResult && cntB>=cntW) {
                String tmp = queueB.pollFirst();
                if (cntB > cntResult  && queueResult.size() > 0)//有更大的记录
                    queueResult.clear();
                queueResult.add(curB ? (queueB.peek() + " " + tmp) : (tmp + " " + queueB.peek()));
                cntResult = cntB;
                queueNames.add(tmp);
            }else if(cntW >= cntResult && cntW>=cntB){
                String tmp = queueW.pollFirst();
                if (cntW > cntResult && queueResult.size() > 0)
                    queueResult.clear();
                queueResult.add(curW ? (queueW.peek() +" "+ tmp) : (tmp + " "+queueW.peek()));
                cntResult = cntB;
                queueNames.add(tmp);
            }
        }
        while (queueResult.size()>0)
            System.out.println(queueResult.poll());
    }
}

