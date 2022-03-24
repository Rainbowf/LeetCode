package leetcode;

import java.util.*;
//offer2q011

class Solution0525 {
    //前缀和
    public int findMaxLength(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int maxLen = 0;
        int sum = 0;
        map.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i] == 0 ? -1 : 1;
            map.putIfAbsent(sum, i);
            maxLen = Math.max(maxLen, i - map.get(sum));
        }
        return maxLen;
    }
}