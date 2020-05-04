package com.steer.algorithm.array;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

/**
 * 2路归并排序
 *
 * 分而治之
 * 1.分成一个个数字
 * 2.两两合并成一个有序的小数组
 * 3.一步步最后合成一个大的有序数组
 */
public class MergeSort {
    static Logger log = LoggerFactory.getLogger(MergeSort.class);

    public static void main(String[] args) {
        int[] arr = new int[]{4,6,10,99,5,16,44,96};
        int[] tempArr = new int[arr.length];
        mergeSort(arr,tempArr,0, arr.length-1);
        log.info("归并后结果:{}", Arrays.toString(arr));
    }

    private static void mergeSort(int[] arr,int[] tempArr, int left, int right) {
        if(null == arr) {
            return;
        }

        if(left < right) {
            //找中间位置进行划分
            int mid = (left+right)/2;
            //对左子序列进行递归归并排序
            mergeSort(arr,tempArr, left, mid);
            //对右子序列进行递归归并排序
            mergeSort(arr, tempArr,mid+1, right);
            //“合”。 进行归并
            merge(arr,tempArr, left, mid, right);
        }
    }

    /**
     *
     * @param arr
     * @param tempArr
     * @param left 左半起始
     * @param mid 中间划分点
     * @param right 右半结束
     */
    private static void merge(int[] arr,int[] tempArr, int left, int mid, int right) {

        int leftStart = left;
        int rightStart = mid+1;
        int tempIndex = left;
        //左半部分数组(有序)   和右变部分数组(有序)  做大小比较
        while(leftStart <= mid && rightStart <= right) {
            //值小的放入临时数组中，最终得到一个临时数组是有序的
            if(arr[leftStart] < arr[rightStart]) {
                tempArr[tempIndex++] = arr[leftStart++];
            } else {
                tempArr[tempIndex++] = arr[rightStart++];
            }
        }

        //左半部分有剩余，临时数组往后塞
        while(leftStart <= mid) {
            tempArr[tempIndex++] = arr[leftStart++];
        }

        //右半部分有剩余，临时数组往后塞；左右同时只可能一边有剩余
        while(rightStart <= right) {
            tempArr[tempIndex++] = arr[rightStart++];
        }

        //把临时数组有序数字 塞给arr
        while(left <= right) {
            arr[left] = tempArr[left++];
        }
    }


}
