package leetcode;

import java.util.*;

//同offer2q094
class Solution0132 {
    public int minCut(String s) {
        //构造回文判断数组
        boolean[][] isPal = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j <= i; j++) {
                if (s.charAt(i) == s.charAt(j) && (i <= j + 1 || isPal[j + 1][i - 1])) {
                    isPal[j][i] = true;
                }
            }
        }
        //构造dp表
        int[] dp = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            if (isPal[0][i]) {
                dp[i] = 0;
            } else {
                dp[i] = i;
                for (int j = 1; j <= i; j++) {
                    if (isPal[j][i]) {
                        //状态转移方程
                        dp[i] = Math.min(dp[i], dp[j - 1] + 1);
                    }
                }
            }
        }
        return dp[s.length() - 1];
    }
}