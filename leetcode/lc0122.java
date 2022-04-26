package leetcode;

import java.util.*;

class Solution0122 {
    public int maxProfit(int[] prices) {
        return 0;
    }

    // 空间复杂度优化版本
    int maxProfit_k_inf(int[] prices) {
        int n = prices.length;
        int dp_i_0 = 0, dp_i_1 = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int dpi0 = dp_i_0;
            int dpi1 = dp_i_1;

            dp_i_0 = Math.max(dpi0, dpi1 + prices[i]);
            dp_i_1 = Math.max(dpi1, dpi0 - prices[i]);
        }
        return dp_i_0;
    }
}