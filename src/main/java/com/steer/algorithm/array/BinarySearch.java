package com.steer.algorithm.array;

/**
 * 二分查找
 * （前提：数组有序）
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = new int[]{4, 6, 5, 10, 16, 34, 44, 46, 96, 99, 398};
        int searchValue = 96;
        int index = binarySearch(arr, searchValue);
        System.out.println("搜索值"+searchValue+"在数组下标:"+index+"处");
    }

    public static int binarySearch(int[] arr, int searchValue) {
        int max = arr.length;
        int min = 0;
        int mid = (max+min)/2;

        while (arr[mid] != searchValue){
            if (arr[mid] > searchValue){
                max = mid -1;
            }else if(arr[mid] < searchValue){
                min = mid +1;
            }

            if (min> max){
                return -1;
            }

            mid = (max + min)/2;
        }

        return mid;
    }
}
