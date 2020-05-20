package com.steer.algorithm.array;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

/**
 * 求一个数的开平方
 */
public class SqrtTest {
    @Test
    public void test(){
        double a = Math.sqrt(5);

        double x = getSquareRoot(5);

        double xx = squareRoot(5);

//        double xxx = mySqrt(5);
        System.out.println(a+ "     "+ x +"    "+xx+"    ");
//        System.out.println(a+ "     "+ x +"    "+xx+"    "+xxx);
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
            mid = low + ((high - low) / 2);
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
        while(low<=high){
            x = (low+high)/2;
            if(x>a/x){
                high = x-0.000001;
            }
            //防止溢出
            if(x<a/x){
                low = x+0.000001;
            }
            if(x==a/x){
                //刚好整除
                return x+0.000001;
            }
        }
        //精确到六位小数
        return new BigDecimal(x).setScale(6, BigDecimal.ROUND_HALF_UP).doubleValue();
    }


    public double mySqrt(int a) {
        double x = a;
        while (x * x > a) {
            x = (x + a / x) / 2;
        }
        return x;
    }


}
