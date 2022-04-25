package offer2;

import java.util.*;

//256
class Solution091 {
    //三序列dp
    public int minCost(int[][] costs) {
        int n = costs.length;

        for (int i = 1; i < n; i++) {
            costs[i][0] += Math.min(costs[i - 1][1], costs[i - 1][2]);
            costs[i][1] += Math.min(costs[i - 1][0], costs[i - 1][2]);
            costs[i][2] += Math.min(costs[i - 1][0], costs[i - 1][1]);
        }
        return Math.min(Math.min(costs[n - 1][0], costs[n - 1][1]), costs[n - 1][2]);
    }

    public int minCost2(int[][] costs) {
        int n = costs.length;
        int[][] dp = new int[2][3];
        dp[0] = costs[0];
        for (int i = 1; i < n; i++) {
            dp[i % 2][0] = Math.min(dp[(i - 1) % 2][1], dp[(i - 1) % 2][2]) + costs[i][0];
            dp[i % 2][1] = Math.min(dp[(i - 1) % 2][0], dp[(i - 1) % 2][2]) + costs[i][1];
            dp[i % 2][2] = Math.min(dp[(i - 1) % 2][0], dp[(i - 1) % 2][1]) + costs[i][2];
        }
        return Math.min(Math.min(dp[(n - 1) % 2][0], dp[(n - 1) % 2][1]), dp[(n - 1) % 2][2]);
    }
}