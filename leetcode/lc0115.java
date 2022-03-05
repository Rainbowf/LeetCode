package leetcode;

import java.util.*;

class Solution0115 {
    public int numDistinct(String s, String t) {
        if (s.length() < t.length()) return 0;

        //1、创建dp表
        int[][] dp = new int[s.length() + 1][t.length() + 1];
        dp[0][0] = 0;
        for (int i = 0; i < s.length(); i++) {
            dp[i + 1][0] = 0;
            for (int j = 0; j <= i && j < t.length(); j++) {
                if (s.charAt(i) == t.charAt(j)) {
                    dp[i + 1][j + 1] = dp[i][j] + dp[i][j + 1];
                } else {
                    dp[i + 1][j + 1] = dp[i][j + 1];
                }
            }
        }
        return dp[s.length()][t.length()];
    }
}