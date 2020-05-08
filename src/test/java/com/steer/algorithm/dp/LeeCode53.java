package com.steer.algorithm.dp;

import org.junit.jupiter.api.Test;

/**
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和.
 *
 * eg.
 * 输入: [-2,1,-3,4,-1,2,1,-5,4],
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 */
public class LeeCode53 {
    int[] nums = new int[]{-2,1,-3,4,-1,2,1,-5,4};

    /**
     * 动态规划
     */
    @Test
    public void test(){
        int max = maxSubArray(nums);
        System.out.println("最大子数组和为:"+max);
    }

    /**
     * 动态规划
     *
     * @param nums
     * @return
     */
    private int maxSubArray(int[] nums) {
        //pre
        int pre = 0, maxAns = nums[0];
        for (int num: nums) {
            pre = Math.max(pre + num, num);
            maxAns = Math.max(maxAns, pre);
        }
        return maxAns;
    }

    /**
     * 动态规划
     */
    @Test
    public void test2(){
        int max = maxSubArray2(nums);
        System.out.println("最大子数组和为:"+max);
    }

    /**
     *      * nums[i]定义为是数组下标为i的值
     *      * f(i) 定义为是以nums[i]结尾的子数组的最大和
     *      * 则f(i) = Max{ f(i-1)+nums[i] , nums[i]};
     *
     *      动态规划模板，但是多定义了dp长度，浪费了一些空间
     * @param nums
     * @return
     */
    private int maxSubArray2(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i- 1] + nums[i], nums[i]);
            if (max < dp[i]) {
                max = dp[i];
            }
        }
        return max;
    }

    /**
     * 分治
     */
    @Test
    public void test3(){
        int max = maxSubArray3(nums);
        System.out.println("最大子数组和为:"+max);
    }

    private int maxSubArray3(int[] nums) {
        return merge(nums,0,nums.length-1);
    }

    private int merge(int[] nums, int left, int right) {
        if (left == right){
            return nums[left];
        }

        int mid = (left + right)/2;
        //左子数组的最大值
        int lSub = merge(nums, left, mid);
        //右子数组的最大值
        int rSub = merge(nums, mid+1, right);

        //计算横跨左右数组的最大子序列和，即以nums[mid]结尾的左子序列和  +  nums[mid+1]开头的右子序列和
        //1.计算nums[mid]为结尾的最大子序列和
        int lSumCross = Integer.MIN_VALUE;
        int lSum = 0;
        for (int i = mid; i >0 ; i--) {
            lSum = lSum + nums[i];
            lSumCross = Math.max(lSumCross,lSum);
        }

        //2.计算nums[mid+1]开头的最大子序列和
        int rSumCross = Integer.MIN_VALUE;
        int rSum = 0;
        for (int i = mid+1; i <right ; i++) {
            rSum = rSum + nums[i];
            rSumCross = Math.max(rSumCross,rSum);
        }

        return Math.max(lSumCross+rSumCross, Math.max(lSub,rSub));
    }
}
