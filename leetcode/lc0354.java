package leetcode;

import java.util.*;

class Solution0354 {
    // envelopes = [[w, h], [w, h]...]
    public int maxEnvelopes(int[][] envelopes) {
        int n = envelopes.length;
        // 按宽度升序排列，如果宽度一样，则按高度降序排列
        Arrays.sort(envelopes, new Comparator<int[]>()
        {
            public int compare(int[] a, int[] b) {
                return a[0] == b[0] ?
                        b[1] - a[1] : a[0] - b[0];
            }
        });
        // 对高度数组寻找 LIS
        int[] height = new int[n];
        for (int i = 0; i < n; i++)
            height[i] = envelopes[i][1];

        return lengthOfLIS(height);
    }

    //二分查找解法 O(NlogN)
    public int lengthOfLIS(int[] nums) {
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