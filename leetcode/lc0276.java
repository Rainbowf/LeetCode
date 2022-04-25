package leetcode;

import java.util.*;
//动态规划

class Solution0276 {
    public int numWays(int n, int k) {
        int[][] dp = new int[n + 1][2];
        dp[0][1] = k;//第一个栅栏有k种涂法（包含0和1两种情况）
        for (int i = 1; i < n; i++) {
            //与前一个栅栏同色
            dp[i][0] = dp[i - 1][1];
            //与前一个栅栏不同色
            dp[i][1] = (dp[i - 1][0] + dp[i - 1][1]) * (k - 1);
        }
        return dp[n - 1][0] + dp[n - 1][1];
    }
}
