package com.steer.algorithm.array;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

/**
 * 2路归并排序
 */
public class MergeSort {
    static Logger log = LoggerFactory.getLogger(MergeSort.class);

    public static void main(String[] args) {
        int[] arr = new int[]{4,6,10,99,5,16,44,96};
        mergeSort(arr,0, arr.length-1);
        log.info("归并后结果:{}", Arrays.toString(arr));
    }

    private static void mergeSort(int[] arr, int left, int right) {
        if(null == arr) {
            return;
        }

        if(left < right) {
            //找中间位置进行划分
            int mid = (left+right)/2;
            //对左子序列进行递归归并排序
            mergeSort(arr, left, mid);
            //对右子序列进行递归归并排序
            mergeSort(arr, mid+1, right);
            //“合”。 进行归并
            merge(arr, left, mid, right);
        }
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        int[] tempArr = new int[arr.length];
        int leftStart = left;
        int rightStart = mid+1;
        int tempIndex = left;

        while(leftStart <= mid && rightStart <= right) {
            if(arr[leftStart] < arr[rightStart]) {
                tempArr[tempIndex++] = arr[leftStart++];
            } else {
                tempArr[tempIndex++] = arr[rightStart++];
            }
        }

        while(leftStart <= mid) {
            tempArr[tempIndex++] = arr[leftStart++];
        }

        while(rightStart <= right) {
            tempArr[tempIndex++] = arr[rightStart++];
        }

        while(left <= right) {
            arr[left] = tempArr[left++];
        }
    }


}
