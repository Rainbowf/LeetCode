package leetcode;

import java.util.*;
//offer2q088

class Solution0070 {
    //一维数组
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length];
        dp[0] = cost[0];
        dp[1] = cost[1];
        for (int i = 2; i < cost.length; i++) {
            dp[i] = Math.min(dp[i - 1], dp[i - 2]) + cost[i];
        }
        return Math.min(dp[cost.length - 2], dp[cost.length - 1]);
    }
    //两个临时变量
    public int minCostClimbingStairs2(int[] cost) {
        int[] dp = new int[]{cost[0], cost[1]};
        for (int i = 2; i < cost.length; i++) {
            dp[i % 2] = Math.min(dp[(i - 1) % 2], dp[(i - 2) % 2]) + cost[i];
        }
        return Math.min(dp[0], dp[1]);
    }

    public int minCostClimbingStairs3(int[] cost) {
        int n = cost.length;
        int prev = 0, curr = 0;
        for (int i = 2; i <= n; i++) {
            int next = Math.min(curr + cost[i - 1], prev + cost[i - 2]);
            prev = curr;
            curr = next;
        }
        return curr;
    }
}