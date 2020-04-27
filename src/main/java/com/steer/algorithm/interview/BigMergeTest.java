package com.steer.algorithm.interview;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Random;

/**
 * 快速排序
 * 归并排序
 * 分而治之思想
 *
 * 有1亿行的一个大文件
 * 怎么快速找出并打印最大的10个数字
 */
public class BigMergeTest {

    static class Entry implements Comparable<Entry> {
        //数值
        long value;
        //文件索引
        int index;

        Entry(long value, int index) {
            this.value = value;
            this.index = index;
        }

        @Override
        public int compareTo(Entry other) {
            if (other.value == value){
                return 0;
            }
            return value - other.value > 0 ? -1 : 1;
        }

        public long getValue() {
            return value;
        }

        public void setValue(long value) {
            this.value = value;
        }

        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }
    }

    public static void main(String[] args) {

        String filePath = "/Users/steer/Desktop/222.txt";

        createRandomFile(filePath);

        long t = System.nanoTime();

        List<String> fileNames = splitFile(filePath);

        mergeSort(fileNames);

        System.out.println("花费时间:"+(System.nanoTime()-t));
    }

    private static List<String> splitFile(String filePath){
        File file = new File(filePath);
        //定义10万行一个文件  1000个文件
        final int SIZE = 100000;
        //临时存放数据
        long[] nums = new long[SIZE];
        List<String> fileNames = new ArrayList<>(1000);
        try (BufferedReader fr = new BufferedReader(new FileReader(file))){
            int index=0;
            for (;;){
                String num = fr.readLine();
                if (num == null){
                    fileNames.add(sortAndSave(nums,index));
                    break;
                }
                nums[index] = Long.valueOf(num);
                index++;
                if (index == SIZE){
                    fileNames.add(sortAndSave(nums,index));
                    index = 0;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return fileNames;
    }

    private static void createRandomFile(String filePath) {
        File file=new File(filePath);
        int numCount = 10000000;
        Random r=new Random();
        if(file.exists()){
            file.delete();
        }
        try(FileWriter fw=new FileWriter(file)) {
            for(int i=0;i<numCount;i++) {
                fw.write(r.nextLong() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String sortAndSave(long[] nums, int size) {
        quickSort(nums,0,size-1);
        return saveSmallFile(nums);
    }

    private static String saveSmallFile(long[] nums) {
        String fileName = "/Users/steer/Desktop/sort"+System.nanoTime()+".txt";
        File file =new File(fileName);
        try (BufferedWriter bw=new BufferedWriter(new FileWriter(file))){
            for(int i=0; i<nums.length; i++){
                bw.write(nums[i]+ "\n");
            }
            return fileName;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void quickSort(long[] arr,int low,int high){
        int i,j;
        long temp,t;
        if(low > high){
            return;
        }
        i=low;
        j=high;
        //基准位
        temp = arr[low];
        while (i < j) {
            //处理右边
            while (temp>=arr[j]&&i<j) {
                j--;
            }
            //处理左边
            while (temp<=arr[i]&&i<j) {
                i++;
            }
            //如果满足条件则交换
            if (i<j) {
                t = arr[j];
                arr[j] = arr[i];
                arr[i] = t;
            }
        }
        //最后将基准为与i和j相等位置的数字交换
        arr[low] = arr[i];
        arr[i] = temp;
        //递归调用左半数组
        quickSort(arr, low, j-1);
        //递归调用右半数组
        quickSort(arr, j+1, high);
    }

    private static void mergeSort(List<String> fileNames){
        List<BufferedReader> readerList = createInputStream(fileNames);

        sortAndPrint(fileNames,readerList);

        closeInputStream(readerList);
    }

    private static void sortAndPrint(List<String> fileNames, List<BufferedReader> readerList) {
        //初始化
        PriorityQueue<Entry> priorityQueue = new PriorityQueue<>(fileNames.size());
        for (int i = 0; i < readerList.size(); i++) {
            try {
                priorityQueue.add(new Entry(Long.parseLong(readerList.get(i).readLine()), i));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        final int OUT_COUNT = 10;
        int count = 0;
        long[] topVals = new long[OUT_COUNT];
        while (!priorityQueue.isEmpty()){
            Entry entry = priorityQueue.poll();
            int index = entry.getIndex();
            topVals[count] = entry.getValue();
            try {
                priorityQueue.add(new Entry(Long.parseLong(readerList.get(index).readLine()), index));
            } catch (IOException e) {
                e.printStackTrace();
            }
            count++;
            if (count == OUT_COUNT){
                break;
            }
        }

        for (int i = 0; i < topVals.length; i++) {
            System.out.println(topVals[i]);
        }
    }

    private static void closeInputStream(List<BufferedReader> readerList) {
        for (int i = 0; i < readerList.size(); i++) {
            try {
                readerList.get(i).close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static List<BufferedReader> createInputStream(List<String> fileNames) {
        List<BufferedReader> readerList =  new ArrayList<>(fileNames.size());
        for (int i = 0; i < fileNames.size(); i++) {
            File file=new File(fileNames.get(i));
            try {
                readerList.add(new BufferedReader(new FileReader(file)));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        return readerList;
    }
}
