package com.steer.algorithm.string;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * 求字符串的全排列
 */
public class PermutationTest {

    static String origin = "122";

    /**
     * 递归
     */
    @Test
    public void test(){
        char[] chars = origin.toCharArray();
        permutation(chars,0,origin.length()-1);
    }

    private void permutation(char[] chars,int from,int to) {
        //递归结束标记
        if (from == to){
            System.out.println(Arrays.toString(chars));
            return;
        }

        //外层：把每个字符放在首位
        for (int i = from; i < chars.length; i++) {
            //和首字符交换位置,把字符后面的依次放在首位
            swap(chars,from,i);
            //去掉第一位，再接下来进行排列
            permutation(chars,from+1,to);
            //再换回来
            swap(chars,from,i);
        }
    }

    /**
     * 交换2个字符在字符数组的位置
     * @param chars
     * @param i1
     * @param i2
     */
    private void swap(char[] chars, int i1,int i2){
        char temp = chars[i1];
        chars[i1] = chars[i2];
        chars[i2] = temp;
    }
}
