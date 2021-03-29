package main.Interviews;

import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;

public class LongestSubString {

    @Test
    public void test() {
        String test1 = "asdsad";
        String test2 = "abcdefabcdefgh";
        String test3 = "abacbdfgacbhjkgl";
        System.out.println(getMaxString(test1));
        System.out.println(getMaxString(test2));
        System.out.println(getMaxString(test3));
    }

    public String getMaxString(String str) {
        if (str.length() <= 1) {
            return str;
        }

        String result = "";
        int maxLen =0;
        int lindex = 0;
        int rindex = 1;

        Deque<Character> deque = new LinkedList<>();
        deque.add(str.charAt(lindex));
        while (lindex <= rindex && rindex < str.length()) {
            if (deque.contains(str.charAt(rindex))) {
                lindex++;
                deque.poll();
                continue;
            }
            deque.offer(str.charAt(rindex));
            if (maxLen < deque.size()) {
                maxLen = deque.size();
                StringBuilder sb = new StringBuilder();
                Object[] objs = deque.toArray();
                for (Object obj : objs) {
                    sb.append(obj);
                }
                result = sb.toString();
            }
            rindex++;
        }

        return result;
    }
}
