package com.steer.algorithm.array;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * 给定一个整数数组 nums 和一个目标值 target，
 * 请你在该数组中找出和为目标值的那 两个 整数，
 * 并返回他们的数组下标.
 *
 * eg.给定 nums = [2, 7, 11, 15], target = 9
 *
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum
 */
public class LeeCode01 {
    int[] arr = new int[]{2,7,11,15};
    int target = 9;

    /**
     * 暴力法
     */
    @Test
    public void test(){

    }

    /**
     * hash
     */
    @Test
    public void test2(){

    }

    /**
     *
     */
    @Test
    public void test3(){
        //排序,按从小到大的顺序
        Arrays.sort(arr);

        int i =0;
        int j = arr.length-1;

        while (i < j){
            if (arr[i]+arr[j] > target){
                j--;
            }else if(arr[i]+arr[j] < target){
                i++;
            }else {
                System.out.println("["+i+","+j+"]");
                j--;
                i++;
            }
        }
    }
}
