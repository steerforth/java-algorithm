package com.steer.algorithm.array;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

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
//    int[] arr = new int[]{2,7,11,15};
    int[] arr = new int[]{3,2,4};
    int target = 6;

    /**
     * 暴力法
     */
    @Test
    public void test(){
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = i+1; j < arr.length; j++) {
                if (arr[i]+arr[j] == target){
                    System.out.println("["+i+","+j+"]");
                }
            }
        }
    }

    /**
     * hash，空间换时间
     * 有重复数字的情况没法解决
     */
    @Test
    public void test2(){
        //key为值,value为下标
        Map<Integer,Integer> map = new HashMap<>(arr.length*4/3+1);
        for(int i =0;i < arr.length;i++){
            if(map.containsKey(target-arr[i])){
                System.out.println("["+map.get(target-arr[i])+","+i+"]");
            }
            map.put(arr[i],i);
        }
    }

    /**
     * 可以输出匹配的数组，但由于排序，下标已改变
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
