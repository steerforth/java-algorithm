package com.steer.algorithm.interview;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 * 1.用计算机生成了N个1到1000之间的随机整数（N≤1000），对于其中重复的数字，只保留一个，把其余相同的数去掉，
 * 2.然后再把这些数从小到大排序
 */
public class Test2 {
    @Test
    public void test(){
//        int n = 10;
//        for (int i =0;i<n;i++) {
//            int a = new Random().nextInt(1000);
//            System.out.println(a);
//        }


        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int[] intArr = new int[n];
            for (int i = 0; i < n; i++) {
                intArr[i] = scanner.nextInt();
            }
            Arrays.sort(intArr);
            for (int i = 0; i < intArr.length; i++) {
                // 第一个数字或者不等于前一个数字都可以输出
                if (i == 0 || intArr[i] != intArr[i - 1]) {
                    System.out.println(intArr[i]);
                }
            }
        }

    }
}
