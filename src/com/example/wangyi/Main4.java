package com.example.wangyi;
import java.util.Scanner;

/**
 * @author Pengllrn
 * @since <pre>2019/8/4 16:36</pre>
 */
public class Main4 {
    private static int row;
    private static int col;
    private static int W;
    private static int lineMaxHeight;
    private static int PX;
    private static int PY;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        W = sc.nextInt();
        int XE = sc.nextInt();
        int YE = sc.nextInt();
        int XC = sc.nextInt();
        int YC = sc.nextInt();
        PX = sc.nextInt();
        PY = sc.nextInt();
        int[][] size = new int[20][2];
        for (int i = 0; i < 20; i++){
            size[i][0] = sc.nextInt();
            size[i][1] = sc.nextInt();
        }
        String sts = sc.next();
        lineMaxHeight = 0;
        for (int i = 0; i < sts.length() / 2 ; i += 2){
            int acs = transInt(sts.charAt(i), sts.charAt(i + 1));
            if(acs == 35){
                if(i == sts.length() - 1) {//没啦
                    increase(XE, YE);
                    break;
                }
                int next = transInt(sts.charAt(i + 2), sts.charAt(i + 3));
                if(next == 114) {//换行
                    row += lineMaxHeight;
                    col = 0;
                    lineMaxHeight = YE;
                    i += 2;
                }else if(next <= 57 && next >= 48){//图片
                    if(next == 49 && i + 4 < sts.length()){//1X
                        int nextn = transInt(sts.charAt(i + 2), sts.charAt(i + 3));
                        if(nextn <= 57 && nextn >= 48){//12
                            int pv = 10 + (nextn - 48);
                            increase(size[pv][0],size[pv][1]);
                            i += 4;
                        }else {
                            increase(size[next - 48][0], size[next - 48][1]);
                            i += 2;
                        }
                    }
                }else if(next == 35){//转义
                    increase(XE, YE);
                    increase(PX, PY);
                    i+=2;
                }else {//无意义
                    increase(XE, YE);
                    increase(PX, PY);
                }
            }else {
                if(acs <= 126 && acs >= 32){
                    increase(XE, YE);
                }else {
                    increase(XC, YC);
                }
                increase(PX, PY);
            }
        }
        System.out.println(row + lineMaxHeight + " " + col);

    }

    private static void increase(int X, int Y){
        if(col + X >= W){
            row += lineMaxHeight + PY;
            col = X;
            lineMaxHeight = Y;
        }else {
            col += X;
            lineMaxHeight = Math.max(lineMaxHeight, Y);
        }
    }


    private static int transInt(char c1, char c2){
        int ans = 0;
        if(c1 <= '9') ans += (c1 - '0') * 16;
        else ans += (c1 - 'A' + 10) * 16;
        if(c2 <= '9') ans += c2 - '0';
        else ans += c2 - 'A' + 10;
        return ans;
    }
}

