package com.steer.algorithm.string;

import com.steer.algorithm.util.StringUtils;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * 求字符串的全排列
 */
public class PermutationTest {

    static String origin = "abb";

    /**
     * 递归
     * 思路:
     * 1234->
     * 1 ***
     * 2 ***
     * 3 ***
     * 4 ***
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
            //过滤重复字符
            if(isSwap(chars,from,i)){
                continue;
            }
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

    /**
     * 判断char[end]是否当过首字符
     * 即判断之前有没重复的字符
     * @param chars
     * @param begin
     * @param end
     * @return
     */
    private boolean isSwap(char[] chars, int begin, int end){
        if (begin == end){
            return false;
        }
        for (int i = begin ; i < end ; i++) {
            if (chars[i] == chars[end]){
                return true;
            }
        }
        return false;
    }

    /**
     * 优化:
     * 空间换时间
     * 可以用数组或hash记录
     */
    @Test
    public void test2(){
        char[] chars = origin.toCharArray();
        permutation2(chars,0,origin.length()-1);
    }

    private void permutation2(char[] chars, int from, int to) {
        //递归结束标记
        if (from == to){
            System.out.println(Arrays.toString(chars));
            return;
        }

        //假设为单字符的
        //出现过在首位，则把数组下标对应的值置为1
        char[] records = new char[256];

        //外层：把每个字符放在首位
        for (int i = from; i < chars.length; i++) {
            //过滤重复字符
            if (records[chars[i]] == 1){
                continue;
            }
            records[chars[i]] = 1;

            //和首字符交换位置,把字符后面的依次放在首位
            swap(chars,from,i);
            //去掉第一位，再接下来进行排列
            permutation(chars,from+1,to);
            //再换回来
            swap(chars,from,i);
        }
    }

    /**
     * 扩展:
     * 获取数字全排列的下一个数
     * eg.2698776->2766789
     *
     * 数组S,长度为N
     * 记k>i;
     * 若S[k]>S[k+1],S[i]<S[i+1]
     *
     *
     * eg.2698776
     * 思路:
     * 1.从右往左找第一个降序的节点，即9
     * 2.从右往左找比节点左侧数大的第一个数，即7
     * 3.交换位置，得2798766
     * 4.将节点开始后面的数字98766反转，既得下一个排列数
     *
     */
    @Test
    public void test3(){
        String num = "765";
        char[] nums = num.toCharArray();
        nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }

    /**
     * @param chars
     * @return
     */
    private boolean nextPermutation(char[] chars){

        int index = findPoint(chars);
        if (index == 0){
            return false;
        }

        for (int i = chars.length-1; i > 0 ; i--) {
            //交换位置
            if (chars[i] > chars[index-1]){
                swap(chars,i,index-1);
                break;
            }
        }

        StringUtils.reverseString(chars,index,chars.length-1);
        return true;
    }

    private int findPoint(char[] chars){
        for (int i = chars.length-1; i > 0; i--) {
            if (chars[i] > chars[i-1]){
                return i;
            }
        }
        return 0;
    }
}
