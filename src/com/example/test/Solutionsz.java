package com.example.test;

import java.util.Arrays;

/**
 * @author Pengllrn
 * @since <pre>2019/7/8 15:25</pre>
 */
public class Solutionsz {
    public boolean isNumeric(char[] str) {
        if(str == null || str.length == 0)
            return false;
        if(isInteger(str)) return true;
        int i = 0;
        for(; i < str.length; i++){
            if(str[i] == 'E' || str[i] == 'e'){//e的左边可以为整数和小数，右边只能为整数
                if(!isInteger(cut(str, i + 1, str.length))) return false;
                if(isInteger(cut(str, 0, i))) return true;
                break;
            }
        }
        for(int j = 0; j < i; j++){
            if(str[j] == '.'){
                if(j == 0) return isInteger(cut(str, j + 1, i));
                if(j == 1) if(str[0] == '+' || str[0] == '-') str[0] = '0';//-.123
                return isInteger(cut(str, 0, j)) && isInteger(cut(str, j + 1, i));
            }
        }
        return false;
    }

    private boolean isInteger(char[] str){//+21 -23 39 +
        if(str.length == 0)
            return false;
        char f = str[0];
        int start = (f == '+' || f == '-') ? 1 : 0;
        for(int i = start; i < str.length; i++){
            if(!isNumber(str[i]))
                return false;
        }
        return start < str.length;
    }

    private boolean isNumber(char c){
        return (c <= '9') && (c >= '0');
    }

    private char[] cut(char[] arr, int start, int end){
        return Arrays.copyOfRange(arr, start, end);
    }

    public static void main(String[] args) {
        boolean numeric = new Solutionsz().isNumeric("1+23".toCharArray());
        System.out.println(numeric);
    }
}
