package com.example.pat;

import java.util.Map;
import java.util.Scanner;

public class Q1014 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] str = new String[4];
        for (int i = 0; i < 4; i++) {
            str[i] = in.next();
        }
        String result = new Solution1014().dateTime(str);
        System.out.println(result);
    }
}

class Solution1014 {
    private final String[] Week = new String[]{"MON", "TUE", "WED", "THU", "FRI", "SAT", "SUN",""};

    public String dateTime(String[] str) {
        int day = 7;
        String time = "00";
        String minute = "00";
//        int max_len1 = Math.min(str[0].length(), str[1].length());
//        int max_len2 = Math.min(str[2].length(), str[3].length());
        for (int i = 0; i < str[0].length(); i++) {
            char a = str[0].charAt(i);
            char b = str[1].charAt(i);
            if (day == 7 && a == b && a - 'A' >= 0 && a - 'A' < 7) {
                day = a - 'A';
            } else if (day != 7 && a == b) {
                if (a - '0' >= 0 && a - '9' <= 0) {
                    time = "0" + a;
                    break;
                } else if ((a - 'A') >= 0 && (a - 'N' )<= 0) {
                    time = String.valueOf(a - 'A' + 10);
                    break;
                }
            }
        }

        for (int i = 0; i < str[2].length(); i++) {
            char a = str[2].charAt(i);
            char b = str[3].charAt(i);
            if (a == b && (a >= 'a' && a <= 'z' || a >= 'A' && a <= 'Z' ) ) {
                if (i < 10)
                    minute = "0" + i;
                else
                    minute = "" + i;
                break;
            }
        }
        return Week[day] + " " + time + ":" + minute;
    }
}
