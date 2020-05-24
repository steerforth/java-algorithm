package com.steer.algorithm.dp;

import org.junit.jupiter.api.Test;

/**
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 *
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。
 *
 * eg.输入: [1,2,3,1]
 * 输出: 4
 *
 * 输入: [2,1,1,2]
 * 输出: 4
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/house-robber
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeeCode198 {

    /**
     * 定义dp[i]为i+1个房子所能窃取的最大金额，则
     * dp[i] = Math.max(dp[i-2]+nums[i], dp[i-1]);
     */
    @Test
    public void test(){
        int[] arr = new int[]{1,3,4,5,6};
        int money = rob(arr);
        System.out.println("最大金额:"+money);
    }

    /**
     * dp空间复杂度可以再优化
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        //定义dp[i]为i+1个房子所能窃取的最大金额，则
        int[] dp = new int[nums.length+1];
        dp[0] = nums[0];
        if(nums.length == 1){
            return dp[0];
        }

        dp[1] =  Math.max(nums[0],nums[1]);

        if(nums.length == 2){
            return dp[1];
        }

        for(int i=2;i<nums.length;i++){
            dp[i] = Math.max( dp[i-2]+nums[i], dp[i-1]);
        }

        return dp[nums.length-1];
    }
}
