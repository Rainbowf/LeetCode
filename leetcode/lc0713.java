package leetcode;

import java.util.*;
//offer2q009

class Solution0713 {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        long mul = 1;
        int i = 0;
        int cnt = 0;
        for (int j = 0; j < nums.length; j++) {
            mul *= nums[j];
            while (i <= j && mul >= k) {
                mul /= nums[i++];
            }
            cnt += (i <= j) ? j - i + 1 : 0;
        }
        return cnt;
    }
}