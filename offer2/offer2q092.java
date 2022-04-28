package offer2;

import java.util.*;

class Solution092 {
    //dp双序列_空间优化
    public int minFlipsMonoIncr(String s) {
        int n = s.length();
        if (n == 0) return 0;

        int[][] dp = new int[2][2];
        char ch = s.charAt(0);

        dp[0][0] = ch == '0' ? 0 : 1;
        dp[1][0] = ch == '1' ? 0 : 1;


        for (int i = 1; i < n; i++) {
            ch = s.charAt(i);
            int prev0 = dp[0][(i - 1) % 2];
            int prev1 = dp[1][(i - 1) % 2];

            dp[0][i % 2] = prev0 + (ch == '0' ? 0 : 1);
            dp[1][i % 2] = Math.min(prev0, prev1) + (ch == '1' ? 0 : 1);
        }

        return Math.min(dp[0][(n - 1) % 2], dp[1][(n - 1) % 2]);
    }
    //前缀和
    public int minFlipsMonoIncr_2(String s) {
        int[] dp = new int[s.length() + 1];
        for (int i = 0; i < s.length(); i++) {
            dp[i + 1] = dp[i] + (s.charAt(i) == '1' ? 1 : 0);
        }
        int res = Integer.MAX_VALUE;
        for (int j = 0; j <= s.length(); j++) {
            res = Math.min(res, dp[j] + s.length() - j - (dp[s.length()] - dp[j]));
        }
        return res;
    }
}