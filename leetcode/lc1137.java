package leetcode;

import java.util.*;
/*
509. 斐波那契数
70. 爬楼梯
 */
class Solution1137 {
    //一维数组dp
    public int tribonacci(int n) {
        if (n < 3) {
            return n < 2 ? n : 1;
        }

        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }
        return dp[n];
    }
}