package com.example.other;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.Arrays;

/**
 * @author Pengllrn
 * @since <pre>2019/6/13 9:19</pre>
 */
public class CharSize {
    public static void main(String[] args) {
        String str = "abcd英文efgh";
        char[] c = str.toCharArray();
        System.out.println(Arrays.toString(c));

        String str1 = "ab英文";
        try {
            byte[] bb = str1.getBytes("GBK");//编码:char --> byte
            String s1 = Charset.defaultCharset().toString();//默认为"UTF-8"
            System.out.println(s1);
            String s = new String(bb,"GBK");//解码:byte -->char
            System.out.println(s);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}
