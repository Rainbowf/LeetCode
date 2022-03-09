package leetcode;

import java.util.*;


class Solution0983 {
    public int mincostTickets(int[] days, int[] costs) {
        // 子问题：dp[i] 表示到第 i 天结束时的最低消费
        // 转移方程：
        // 如果第 i 天需要通行证，dp[i] = min(dp[i - 1] + cost[0], dp[i - 7] + cost[1], dp[i - 30] + cost[2])
        // 如果第 i 天不需要通行证，dp[i] = dp[i - 1]

        int lastDay = days[days.length - 1];
        int[] dp = new int[lastDay + 1];

        int index = 0;
        for (int i = 1; i <= lastDay; i++) {
            if (i == days[index]) {
                dp[i] = Math.min((i >= 1 ? dp[i - 1] : 0) + costs[0],
                        Math.min((i >= 7 ? dp[i - 7] : 0) + costs[1],
                                (i >= 30 ? dp[i - 30] : 0) + costs[2]));
                index++;
            } else {
                dp[i] = dp[i - 1];
            }
        }
        return dp[lastDay];
    }
}