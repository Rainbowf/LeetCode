package leetcode;

import java.util.*;

class Solution0309 {
    public int maxProfit(int[] prices) {
        return 0;
    }

    /*
    dp[i][0] = max(dp[i-1][0], dp[i-1][1] + prices[i])
    dp[i][1] = max(dp[i-1][1], dp[i-2][0] - prices[i])
    解释：第 i 天选择 buy 的时候，要从 i-2 的状态转移，而不是 i-1 。
    */

    // 空间复杂度优化版本
    int maxProfit_k_inf_cool_1(int[] prices) {
        int dp_ii_0 = 0, dp_i_0 = 0, dp_i_1 = Integer.MIN_VALUE;

        for(int i = 0; i < prices.length; i++){
            int dpii0 = dp_ii_0, dpi0 = dp_i_0 , dpi1 = dp_i_1;

            dp_ii_0 = dpi0;
            dp_i_0  = Math.max(dpi0, dpi1 + prices[i]);
            dp_i_1  = Math.max(dpi1, dpii0 - prices[i]); //前两天
        }
        return dp_i_0;
    }
}