package leetcode;

import java.util.*;

class Solution0123 {
    public int maxProfit(int[] prices) {
        return 0;
    }

    // 状态转移方程：
    // dp[i][2][0] = max(dp[i-1][2][0], dp[i-1][2][1] + prices[i])
    // dp[i][2][1] = max(dp[i-1][2][1], dp[i-1][1][0] - prices[i])
    // dp[i][1][0] = max(dp[i-1][1][0], dp[i-1][1][1] + prices[i])
    // dp[i][1][1] = max(dp[i-1][1][1], -prices[i])

    // 空间复杂度优化版本
    int maxProfit_k_2(int[] prices) {
        // base case
        int dp_i10 = 0, dp_i11 = Integer.MIN_VALUE;  //i = -1
        int dp_i20 = 0, dp_i21 = Integer.MIN_VALUE;  //k = 0
        for (int price : prices) {
            dp_i20 = Math.max(dp_i20, dp_i21 + price);
            dp_i21 = Math.max(dp_i21, dp_i10 - price);
            dp_i10 = Math.max(dp_i10, dp_i11 + price);
            dp_i11 = Math.max(dp_i11, -price);
        }
        return dp_i20;
    }

}