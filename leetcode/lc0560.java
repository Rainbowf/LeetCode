package leetcode;

import java.util.*;
//offer2q010

class Solution0560 {
    public int subarraySum(int[] nums, int k) {
        //前缀和解法
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int count = 0;
        map.put(0, 1);
        for (int num : nums) {
            sum += num;
            count += map.getOrDefault(sum - k, 0);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}