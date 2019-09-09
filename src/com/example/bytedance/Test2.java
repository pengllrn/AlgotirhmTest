package com.example.bytedance;

/**
 * @author Pengllrn
 * @since <pre>2019/7/1 13:08</pre>
 */
public class Test2 {
    public static void main(String[] args) {
        class Solution {
            public String solve(String s) {
                if (s.length() < 3) return s;
                if (s.length() < 4 && ((s.charAt(0) == s.charAt(1)) && (s.charAt(1) == s.charAt(2))))
                    return delete(s, 2);
                for (int i = 0; i < s.length() - 3; i++) {
                    if ((s.charAt(i) == s.charAt(i + 1)) && (s.charAt(i + 1) == s.charAt(i + 2))) {//AABB
                        s = delete(s, i);
                        i--;
                    } else if ((s.charAt(i) == s.charAt(i + 1)) && (s.charAt(i + 2) == s.charAt(i + 3))) {//AAA
                        s = delete(s, i + 3);
                        i--;
                    }
                }
                char c = s.charAt(s.length() - 2);
                if (((s.charAt(s.length() - 3) == c) && (c == s.charAt(s.length() - 1))))
                    s = delete(s, s.length() - 1);
                return s;
            }

            private String delete(String s, int a) {
                StringBuilder s2 = new StringBuilder();
                for (int i = 0; i < a; i++) {
                    s2.append(s.charAt(i));
                }
                for (int i = a + 1; i < s.length(); i++) {
                    s2.append(s.charAt(i));
                }
                return s2.toString();
            }
        }

        String s = "baaaaaaa";
        Solution solution = new Solution();
        System.out.println(solution.solve(s));
    }
}
