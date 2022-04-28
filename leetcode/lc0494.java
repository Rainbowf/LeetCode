package leetcode;

import java.util.*;

class Solution0494 {
    //回溯+dp表
    // 备忘录
    HashMap<String, Integer> memo = new HashMap<>();

    public int findTargetSumWays(int[] nums, int target) {
        if (nums.length == 0) return 0;
        return helper(nums, 0, target);
    }


    private int helper(int[] nums, int i, int target) {
        if (i == nums.length) {
            return target == 0 ? 1 : 0;
        }
        // 把它俩转成字符串才能作为哈希表的键
        String key = i + "," + target;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        // 还是穷举
        int result = helper(nums, i+1, target - nums[i]) + helper(nums, i+1, target + nums[i]);
        // 记入备忘录
        memo.put(key, result);
        return result;
    }
}