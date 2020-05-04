package com.steer.algorithm.array;

import java.util.Arrays;

/**
 * 插入排序
 *
 * 1.规定第一个数
 * 2.后面的数与前一个比较，小了，就依次和前面的数比较
 * 3.若前面的数比该数大，则把前面的数位置索引往后退一位
 * 4.若前面的数比该数小，则把该数值赋值给它
 */
public class InsertSort {
    //升序
    public static void main(String[] args) {
        int[] arr = new int[]{4,6,10,99,5,16,44,96};

        int temp;
        for (int i = 1; i < arr.length; i++) {
            //把arr[i]排到前面去
            if (arr[i] < arr[i-1]){
                temp = arr[i];
                //往前数数
                for (int j=i;j>0;j--){
                    if (j>0 && arr[j-1]>temp){
                        //交换值
                        arr[j] = arr[j-1];
                    }else{
                        arr[j] =temp;
                        break;
                    }
                }
            }
        }

        System.out.println(Arrays.toString(arr));
    }
}
