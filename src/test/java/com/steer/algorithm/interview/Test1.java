package com.steer.algorithm.interview;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 输入：n = 3
 * 输出：[
 *        "((()))",
 *        "(()())",
 *        "(())()",
 *        "()(())",
 *        "()()()"
 *      ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/generate-parentheses
 */
public class Test1 {


    @Test
    public void test(){
        int n = 4;
        List<String> list = generateParenthesis(n);
        System.out.println("数量:"+list.size());
        list.stream().forEach(s -> System.out.println(s));
    }

    public List<String> generateParenthesis(int n) {

        List<String> list = new ArrayList<>();

        add(list,"(",n,1);

        return list;

    }

    public void add(List<String> list, String text, int n, int n1){
        if(text.length() == n * 2){
            list.add(text);
            return;
        }

        if(n1 < n){
            add(list,text + "(",n,n1+1);
        }
        if(n1 > text.length() / 2) {
            add(list, text + ")", n, n1);
        }
    }

    /**
     * 回溯
     */
    @Test
    public void test2(){
        int n= 3;
        List<String> list = generateParenthesis2(n);
        System.out.println("数量:"+list.size());
        list.stream().forEach(s -> System.out.println(s));
    }

    private List<String> generateParenthesis2(int n) {
        List<String> list = new ArrayList<>();
        if (n < 1){
            return list;
        }
        backTrack("",n,n,list);
        return list;
    }

    /**
     * @param str
     * @param left 剩余'('的数量
     * @param right 剩余')'的数量
     * @param list
     */
    private void backTrack(String str, int left, int right, List<String> list) {
        System.out.println("left:"+left+"  right:"+right+"  str:"+str);
        if (left ==0 && right ==0){
            list.add(str);
            return;
        }
        if (left > 0){
            //当'('数量还有,就可以放
            backTrack(str+"(",left-1,right,list);
        }
        //当')'剩余数量比'('的数量多,肯定可以放')'
        if (right > left){
            backTrack(str+")",left,right-1,list);
        }
    }
}
