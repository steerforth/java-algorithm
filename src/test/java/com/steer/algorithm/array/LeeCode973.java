package com.steer.algorithm.array;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * 我们有一个由平面上的点组成的列表 points。需要从中找出 K 个距离原点 (0, 0) 最近的点。
 *
 * eg.
 * 输入：points = [[3,3],[5,-1],[-2,4]], K = 2
 * 输出：[[3,3],[-2,4]]
 * （答案 [[-2,4],[3,3]] 也会被接受。）
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/k-closest-points-to-origin
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeeCode973 {
    @Test
    public void test(){
        //二维数组，  3行2列
        int[][] points = new int[][]{{3,3},{5,-1},{-2,4}};

        int[][] newArr = kClosest(points,2);

        for (int i = 0; i < newArr.length; i++) {
            System.out.println("["+newArr[i][0]+","+newArr[i][1]+"]");
        }

    }

    private int[][] kClosest(int[][] points, int K){
        //升序排序
        Arrays.sort(points,(p1,p2)->{
            double d1 = p1[0]*p1[0] + p1[1]*p1[1];
            double d2 = p2[0]*p2[0] + p2[1]*p2[1];
            return (int) (d1-d2);
        });

        int[][] newArr = new int[K][0];
        for (int i = 0; i < K; i++) {
            newArr[i] = points[i];
        }
        return newArr;
    }
}
