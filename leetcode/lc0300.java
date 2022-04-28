package leetcode;

import java.util.*;


class Solution0300 {
    //动态规划 O(n^2)
    public int lengthOfLIS(int[] nums) {
        //base case: 单个数组为1，包含本id的最长长度
        //对于当前数，查找前面所有的数
        int res = 1;
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    //二分查找解法 O(NlogN)
    public int lengthOfLIS2(int[] nums) {
        int[] top = new int[nums.length];
        //牌堆数初始化为0
        int piles = 0;

        for (int i = 0; i < nums.length; i++) {
            // 要处理的扑克牌
            int poker = nums[i];

            /*二分查找，左边界，查找范围：左闭右开*/
            int l = 0, r = piles;
            while (l < r) {
                int m = l + (r - l) / 2;
                if (top[m] < poker) {
                    l = m + 1;
                }else {
                    r = m;
                }
            }
            /*如果没找到合适的牌堆，新建一堆*/
            if(l == piles) piles++;
            // 把这张牌放到牌堆顶
            top[l] = poker;
        }
        // 牌堆数就是 LIS 长度
        return piles;
    }
}