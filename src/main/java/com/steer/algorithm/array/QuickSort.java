package com.steer.algorithm.array;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

/**
 * 快速排序, 是对冒泡排序的一种改进
 * 时间平均复杂度O(nlogn)
 * 双轴快排  Arrays.sort() 把序列分成三段
 */
public class QuickSort {
    static private Logger log = LoggerFactory.getLogger(QuickSort.class);

    public static void main(String[] args) {
        int[] arr = new int[]{4,6,10,99,5,16,44,96};

        quickSort(arr, 0, arr.length - 1);

        log.info("排序后结果:{}", Arrays.toString(arr));
    }

    //升序
    /**
     *         TEMP
     *           \
     *  XXXXXXXX L XXXXXXXXX R XXXXX
     * @param arr
     * @param l
     * @param r
     */
    private static void quickSort(int[] arr, int l, int r) {
        if (l >= r){
            return;
        }

        int leftIndex = l;
        int rightIndex = r;
        //作为基准
        int key = arr[leftIndex];

        //从左右两边交替扫描，直到leftIndex = rightIndex
        while (leftIndex < rightIndex) {
            //!!!这里一定要加=号
            while (leftIndex < rightIndex && arr[rightIndex] >= key) {
                //从右往左扫描，找到第一个比基准值小的元素
                rightIndex--;
            }

            //找到这种元素将arr[rightIndex]放入arr[leftIndex]中
            arr[leftIndex] = arr[rightIndex];

            while (leftIndex < rightIndex && arr[leftIndex] <= key) {
                //从左往右扫描，找到第一个比基准值大的元素
                leftIndex++;
            }

            //找到这种元素将arr[leftIndex]放入arr[rightIndex]中
            arr[rightIndex] = arr[leftIndex];
        }
        //其实这里leftIndex=rightIndex
//        System.out.println(leftIndex+"---"+rightIndex);

        //4,6,10,99,5,16,44,96
        //基准值归位到新的left指针处
        arr[leftIndex] = key;

        //第一次排序后： 基准值左边的都是比基准值小的数，基准值右边的都是比基准值大的数
        //对基准值左边的元素进行递归排序
        quickSort(arr, l, leftIndex - 1);
        //**当前leftIndex至rightIndex都是比基准值key大的数
        //对基准值右边的元素进行递归排序。
        quickSort(arr, rightIndex + 1, r);

    }
}
