package com.example.other;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author Pengllrn
 * @since <pre>2019/6/13 9:02</pre>
 */
public class FileCopy1 {
    public static void copyFile(String src,String dist) throws IOException {
        FileInputStream in = new FileInputStream(src);
        BufferedInputStream bufferedInputStream = new BufferedInputStream(in);
        FileOutputStream out = new FileOutputStream(dist);
        byte[] buffer = new byte[1024 * 24];
        int cnt;
        while ((cnt = bufferedInputStream.read(buffer,0,buffer.length)) != 0){
            out.write(buffer,0,cnt);
        }
        out.close();
        bufferedInputStream.close();
    }
}
