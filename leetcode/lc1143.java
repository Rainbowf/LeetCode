package leetcode;
import java.util.*;

/***相似题目***
 *  712. 两个字符串的最小ASCII删除和
 *  583. 两个字符串的删除操作
 * 1143. 最长公共子序列
*/

class Solution1143 {
    public int longestCommonSubsequence(String text1, String text2) {
        int len1 = text1.length();
        int len2 = text2.length();
        //1、创建二维dp表
        int[][] dp = new int[len1 + 1][len2 + 1];
        //2、根据转移方程填充，注意起点和索引对应关系
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[len1][len2];
    }
}