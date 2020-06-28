package com.steer.algorithm.huawei;

import org.junit.jupiter.api.Test;

import java.util.Scanner;

public class Test1 {
    @Test
    public void test(){
//        Scanner sc=new Scanner(System.in);
//
//        while(sc.hasNextInt())
//        {
//            int n=sc.nextInt();
//            if(n != 0){
//                System.out.println(Drink(n));
//            }
//        }
//        sc.close();
        int n = 10;
        System.out.println(Drink(n));
    }

    private int Drink(int n) {
        if(n==2)
            return 1;
        else if(n==1)
            return 0;
        else//此时表明对应为3的倍数，递归
        {
            return n/3+Drink(n%3+n/3);
        }
    }
}
