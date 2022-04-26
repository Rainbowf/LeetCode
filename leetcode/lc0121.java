package leetcode;

import java.util.*;

class Solution0121 {
    public int maxProfit(int[] prices) {
        int mini = 0;
        int res = 0;
        for (int i = 0; i < prices.length; i++) {
            res = Math.max(prices[i] - prices[mini], res);

            if (prices[i] < prices[mini]) {
                mini = i;
            }
        }
        return res;
    }

    // 空间复杂度优化版本
    int maxProfit_k_1(int[] prices) {
        int n = prices.length;
        // base case: dp[-1][0] = 0, dp[-1][1] = -infinity
        int dp_i_0 = 0, dp_i_1 = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            // dp[i][0] = max(dp[i-1][0], dp[i-1][1] + prices[i])
            dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);
            // dp[i][1] = max(dp[i-1][1], -prices[i])
            dp_i_1 = Math.max(dp_i_1, -prices[i]);
        }
        return dp_i_0;
    }
}