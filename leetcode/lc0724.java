package leetcode;

import java.util.*;
//offer2q012
class Solution0724 {
    public int pivotIndex(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int temp = 0;
        for (int i = 0; i < nums.length; i++) {
            temp += nums[i];
            if (temp - nums[i] == sum - temp) {
                return i;
            }
        }
        return -1;
    }
}