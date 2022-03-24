package leetcode;

import java.util.*;
//offer2q008
class Solution0209 {
    //双指针for+while
    public int minSubArrayLen(int target, int[] nums) {
        int i = 0;
        int minLen = nums.length + 1;
        int sum = 0;
        for (int j = 0; j < nums.length; j++) {
            sum += nums[j];
            while (i <= j && sum >= target) {
                minLen = Math.min(minLen, j - i + 1);
                sum -= nums[i++];
            }
        }
        return minLen == nums.length + 1 ? 0 : minLen;
    }
}