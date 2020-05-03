package com.steer.algorithm.string;

import com.steer.algorithm.util.StringUtils;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * 要求把字符串前k个字符，移到字符串尾部
 * eg. 'abcdef'移动前2个，则新的为'cdefab'
 */
public class LeftMoveTest {

    /**
     * 思路:
     * ab取镜像为ba
     * cdef取镜像为fedc
     * 则结果为bafedc的镜像，即cdefab
     */
    @Test
    public void test(){
        //移动2位
        char[] origin = new char[]{'a','b','c','d','e','f'};
        int size = 2;

        StringUtils.reverseString(origin,0,size-1);
        StringUtils.reverseString(origin,size,origin.length-1);
        StringUtils.reverseString(origin,0,origin.length-1);

        System.out.println(Arrays.toString(origin));

    }



}
