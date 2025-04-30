package com.steer.algorithm.array;

import java.util.Arrays;

/**
 * 选择排序
 * 时间平均复杂度(O(n^2)),不稳定
 */
public class SelectSort {
    /**
     * 从0索引开始，依次和后面元素比较，小的往前放，第一次完毕，最小值出现在最小索引处
     * @param args
     */
    public static void main(String[] args) {
        int[] arr = new int[]{4,6,10,99,5,16,44,96,398,46,34};
//1,3,4
        for (int i = 0; i < arr.length-1; i++) { //-1是外层循环次数少
            for (int j = i+1; j < arr.length; j++) {
                if (arr[i] > arr[j]){
                    int temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
            }
        }

        System.out.println(Arrays.toString(arr));
    }
}
