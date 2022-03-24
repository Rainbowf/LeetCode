package leetcode;

import java.util.*;
//offer2q016

class Solution0003 {
    //双指针+滑动窗口
    public int lengthOfLongestSubstring(String s) {
        int[] map = new int[256];
        int len = s.length();
        if (len == 0) return 0;

        int maxLen = 0;
        for (int i = 0, j = 0; i < len; i++) {
            while (i <= j && j < len && map[s.charAt(j)] < 1) {
                map[s.charAt(j)] += 1;
                maxLen = Math.max(maxLen, j - i + 1);
                j++;
            }
            map[s.charAt(i)] -= 1;
        }
        return maxLen;
    }
}