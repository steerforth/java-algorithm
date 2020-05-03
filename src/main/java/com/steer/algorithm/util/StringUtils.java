package com.steer.algorithm.util;

public class StringUtils {

    public static char[] reverseString(char[] chars,int from, int to){
        while (from < to){
            char temp = chars[from];
            chars[from] = chars[to];
            chars[to] = temp;
            to--;
            from++;
        }
        return chars;
    }
}
