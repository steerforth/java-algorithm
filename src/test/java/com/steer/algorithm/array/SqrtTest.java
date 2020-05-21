package com.steer.algorithm.array;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

/**
 * 求一个数的开平方
 * 要求精确到小数点后6位
 */
public class SqrtTest {
    @Test
    public void test(){
        double a = Math.sqrt(5);

        double x = getSquareRoot(5);

        double xx = squareRoot(5);

        double xxx = newtonSqrt(5);

        System.out.println("Math.sqrt:"+a);
        System.out.println("二分法1:"+x);
        System.out.println("二分法2:"+xx);
        System.out.println("牛顿法:"+xxx);
    }

    /**
     * 方法1 精确度差
     * @param data
     * @return
     */
    public static double getSquareRoot(int data){
        if(data < 0){
            return -1;
        }
        double low = 0.0;
        double high = data;
        double mid = 0.0;
        while(isNumOfDigLessThenInput(mid, 6) ){
            mid = low + (high - low) / 2;
            if(data == mid*mid){
                return mid;
            }else if(data < mid*mid){
                high = mid;
            }else{
                low = mid;
            }
        }
        return mid;
    }

    private static boolean isNumOfDigLessThenInput(double data,int num){
        String dataStr = String.valueOf(data);
        int index = dataStr.indexOf(".");
        if(index == -1){
            return true;
        }
        int numofDig = dataStr.length() - index;
        return numofDig <= 6;
    }

    /**
     * 方法2，易于理解，精确度高
     * @param a
     * @return
     */
    public static Double squareRoot(int a){
        double x = 0;
        double low = 0;
        double high = a;
        while(low <= high){
            x = low + (high - low) / 2;
            if(x>a/x){
                high = x-0.000001;
            }
            //防止溢出
            if(x<a/x){
                low = x+0.000001;
            }
            if(x==a/x){
                //刚好整除??? 这里只是为了精度？？
                return x+0.000001;
            }
        }
        //精确到六位小数
        return new BigDecimal(x).setScale(6, BigDecimal.ROUND_HALF_UP).doubleValue();
    }


    //牛顿法

    /**
     *
     * 求x^2-a =f(x)曲线与x轴正向的交点。用切点直线不断逼近的办法求解。
     *
     * 已知 f'(x) = 2x;
     * 在X1点处的切线为f(x)-f(x1)=f'(x1)(x - x1)
     * 与x轴的交点为(即f(x)=0)： x = (x1^2+a)/(2*x1)--> x =(x1+a/x1)/2
     *
     * @param a
     * @return
     */
    public double newtonSqrt(int a) {
        double x = a;
        //精度
        double p = 1e-6;
        while ((x * x- a) > p) {
            x = (x + a / x) / 2.0;
        }
        return x;
    }


}
