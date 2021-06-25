package com.steer.algorithm.array;

import java.util.Arrays;

/**
 * 冒泡排序
 * 时间平均复杂度O(n^2),稳定
 */
public class BubbleSort {
    /**
     * 相邻元素两两比较，大的往后放。第一次完毕后，最大值就出现在最大索引处
     * @param args
     */
    public static void main(String[] args) {
        int[] arr = new int[]{4,6,10,99,5,16,44,96};

        for (int i = 0; i < arr.length-1; i++) {
            for (int j = 0; j < arr.length-1-i; j++) {
                //前面的比后面的大，两两交换位置
                if (arr[j] > arr[j+1]){
                    int temp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = temp;
                }
            }
        }

        System.out.println(Arrays.toString(arr));

    }
}
