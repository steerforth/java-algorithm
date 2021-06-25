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
     * @param leftIndex
     * @param rightIndex
     */
    private static void quickSort(int[] arr, int leftIndex, int rightIndex) {
        log.info("{}  -- {}",leftIndex,rightIndex);
        if (leftIndex >= rightIndex){
            return;
        }

        int left = leftIndex;
        int right = rightIndex;
        //作为基准
        int key = arr[left];

        //从左右两边交替扫描，直到left = right
        while (left < right) {
            //!!!这里一定要加=号
            while (right > left && arr[right] >= key) {
                //从右往左扫描，找到第一个比基准值小的元素
                right--;
            }

            //找到这种元素将arr[right]放入arr[left]中
            arr[left] = arr[right];

            while (left < right && arr[left] <= key) {
                //从左往右扫描，找到第一个比基准值大的元素
                left++;
            }

            //找到这种元素将arr[left]放入arr[right]中
            arr[right] = arr[left];
        }
        //4,6,10,99,5,16,44,96
        //基准值归位
        arr[left] = key;
        //对基准值左边的元素进行递归排序
        quickSort(arr, leftIndex, left - 1);
        //对基准值右边的元素进行递归排序。
        quickSort(arr, right + 1, rightIndex);
        //其实这里left=right
    }
}
