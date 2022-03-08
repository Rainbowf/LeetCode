package offer2;

import java.util.*;
//152,
class Solution089 {
    //一维数组dp
    public int rob1(int[] nums) {
        //边界
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        if (nums.length > 1) {
            dp[1] = Math.max(nums[0], nums[1]);
        }

        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return dp[nums.length - 1];
    }

    //两个变量dp
    public int rob2(int[] nums) {
        int[] dp = new int[2];
        dp[0] = nums[0];
        if (nums.length > 1) {
            dp[1] = Math.max(nums[0], nums[1]);
        }
        for (int i = 2; i < nums.length; i++) {
            dp[i % 2] = Math.max(dp[(i - 2) % 2] + nums[i], dp[(i - 1) % 2]);
        }
        return dp[(nums.length - 1) % 2];
    }

    //双序列O(1)dp
    public int rob3(int[] nums) {
        int[][] dp = new int[2][2];
        dp[0][0] = 0;       //不抢当前屋
        dp[1][0] = nums[0]; //抢当前屋

        for (int i = 1; i < nums.length; i++) {
            //不抢当前屋 = 前一个位置：抢+不抢
            dp[0][i % 2] = Math.max(dp[0][(i - 1) % 2], dp[1][(i - 1) % 2]);
            //抢当前屋 = 当前屋价值 + 不抢前一屋
            dp[1][i % 2] = nums[i] + dp[0][(i - 1) % 2];
        }
        return Math.max(dp[0][(nums.length - 1) % 2], dp[1][(nums.length - 1) % 2]);
    }
}