package leetcode;

import java.util.*;

//offer2q092

class Solution0926 {
    //dp思路_空间未优化
    public int minFlipsMonoIncr(String s) {
        int[] dp_0 = new int[s.length()];
        int[] dp_1 = new int[s.length()];

        char ch = s.charAt(0);

        dp_0[0] = ch == '0' ? 0 : 1;
        dp_1[0] = ch == '1' ? 0 : 1;

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                dp_0[i] = dp_0[i - 1];
                dp_1[i] = Math.min(dp_0[i - 1], dp_1[i - 1]) + 1;
            } else {
                dp_1[i] = Math.min(dp_0[i - 1], dp_1[i - 1]);
                dp_0[i] = dp_0[i - 1] + 1;
            }
        }
        return Math.min(dp_0[s.length() - 1], dp_1[s.length() - 1]);
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