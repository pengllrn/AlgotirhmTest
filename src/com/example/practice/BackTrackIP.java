package com.example.practice;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Pengllrn
 * @since <pre>2019/8/1 23:11</pre>
 */
public class BackTrackIP {
    public List<String> restoreIpAddresses(String s) {
        List<String> ans = new ArrayList<>();
        if(s == null || s.length() < 4 || s.length() > 12)
            return ans;
        backtrack(ans, s, 0, 0, new StringBuilder());
        return ans;
    }

    private void backtrack(List<String> ans, String s, int start, int count, StringBuilder sb){
        if(count == 4 || start >= s.length()){
            if(count == 4 && start == s.length())
                ans.add(sb.toString());
            return ;
        }
        for(int i = start; i < start + 3 && i < s.length(); i++){
            if(i != start && s.charAt(start) == '0')
                break;
            String part = s.substring(start, i + 1);
            if(Integer.valueOf(part) > 255) continue;
            if(sb.length() != 0) part = "." + part;
            sb.append(part);
            backtrack(ans, s, i + 1, count + 1, sb);
            sb.delete(sb.length() - part.length(), sb.length());
        }
    }

    public static void main(String[] args) {
        BackTrackIP btIp = new BackTrackIP();
        List<String> strings = btIp.restoreIpAddresses("25525511135");
        System.out.println(strings);
    }
}
