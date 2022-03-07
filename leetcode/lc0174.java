package leetcode;

import java.util.*;
/*
62. 不同路径
63. 不同路径 II
64. 最小路径和
174. 地下城游戏
741. 摘樱桃
剑指 Offer II 098. 路径的数目
剑指 Offer II 099. 最小路径之和
 */

class Solution0174 {
    //二维数组dp
    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length;
        int n = dungeon[0].length;

        dungeon[m - 1][n - 1] = Math.max(1 - dungeon[m - 1][n - 1], 1);
        //第n-1列填充
        for (int i = m - 2; i >= 0; i--) {
            dungeon[i][n - 1] = Math.max(dungeon[i + 1][n - 1] - dungeon[i][n - 1], 1);
        }
        //第m-1行填充
        for (int j = n - 2; j >= 0; j--) {
            dungeon[m - 1][j] = Math.max(dungeon[m - 1][j + 1] - dungeon[m - 1][j], 1);
        }
        //剩余填充
        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                dungeon[i][j] = Math.max(Math.min(dungeon[i + 1][j], dungeon[i][j + 1]) - dungeon[i][j], 1);
            }
        }
        return dungeon[0][0];
    }

    public int calculateMinimumHP2(int[][] dungeon) {
        int n = dungeon.length, m = dungeon[0].length;
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i <= n; ++i) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        dp[n][m - 1] = dp[n - 1][m] = 1;
        for (int i = n - 1; i >= 0; --i) {
            for (int j = m - 1; j >= 0; --j) {
                int minn = Math.min(dp[i + 1][j], dp[i][j + 1]);
                dp[i][j] = Math.max(minn - dungeon[i][j], 1);
            }
        }
        return dp[0][0];
    }
}
