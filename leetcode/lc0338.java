package leetcode;

import java.util.*;

//offer2q003

class Solution003 {
    //1.Brian Kernighan 算法
    //时间：O(nk),k = 位数
    public int[] countBits(int n) {
        int[] result = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            int j = i;
            while (j != 0) {
                result[i]++;
                j = j & (j - 1);
            }
        }
        return result;
    }
    //2.动态规划
    //时间：O(n)
    public int[] countBits2(int n) {
        int[] result = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            result[i] = result[i & (i - 1)] + 1;
        }
        return result;
    }
    //3.动态规划，优化运算
    public int[] countBits3(int n) {
        int[] result = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            result[i] = result[i >> 1] + (i & 1);
        }
        return result;
    }
}