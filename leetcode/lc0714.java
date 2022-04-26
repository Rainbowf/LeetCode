package leetcode;

import java.util.*;
class Solution0714 {
    public int maxProfit(int[] prices, int fee) {
        return 0;
    }
    /*
        dp[i][0] = max(dp[i-1][0], dp[i-1][1] + prices[i])
        dp[i][1] = max(dp[i-1][1], dp[i-1][0] - prices[i] - fee)
        解释：相当于买入股票的价格升高了。
        在第一个式子里减也是一样的，相当于卖出股票的价格减小了。
        如果直接把 fee 放在第一个式子里减，会有一些测试用例无法通过，错误原因是整型溢出而不是思路问题。
        一种解决方案是把代码中的 int 类型都改成 long 类型，避免 int 的整型溢出。
    */

    // 空间复杂度优化版本
    int maxProfit_k_inf_fee(int[] prices, int fee) {
        int dp_i_0 = 0, dp_i_1 = Integer.MIN_VALUE;
        for (int i = 0; i < prices.length; i++) {
            int dpi0 = dp_i_0, dpi1 = dp_i_1;
            dp_i_0 = Math.max(dpi0, dpi1 + prices[i]);
            dp_i_1 = Math.max(dpi1, dpi0 - prices[i] - fee);
        }
        return dp_i_0;
    }
}
