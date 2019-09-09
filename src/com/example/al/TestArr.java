package com.example.al;

/**
 * @author Pengllrn
 * @since <pre>2019/8/19 21:21</pre>
 */
public class TestArr {
        public static void  main(String[] arg){
            int len = 21;
            if(len <= 0) return;
            char[] arr = new char[len];
            for(int i = 0; i < len; i++){
                arr[i] = (char) ('A' + i);
            }
            int i = 0; int j = len - 1;
            if(i == j){
                System.out.println(arr[i]);
                return;
            }
            while(i < j){
                char c = arr[i];
                arr[i] = arr[j];
                arr[j] = c;
                i++;
                j--;
            }
            for(int k = 0; k < len; k++){
                System.out.print(arr[k] + " ");
            }
        }
}
