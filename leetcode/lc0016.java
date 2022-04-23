package leetcode;

import java.util.*;


class Solution0016 {
    public int threeSumClosest(int[] nums, int target) {
        //先排序
        Arrays.sort(nums);
        //两重循环，双指针
        int res = 0;
        int minD = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            int newTarget = target - nums[i];
            int j = i + 1, k = nums.length - 1;
            while (j < k) {
                int sum = nums[j] + nums[k];
                if (Math.abs(sum - newTarget) < minD) {
                    minD = Math.abs(sum - newTarget);
                    res = nums[i] + sum;
                }
                if (sum > newTarget) {
                    k--;
                } else if(sum < newTarget){
                    j++;
                }else {
                    return target;
                }
            }
        }
        return res;
    }
}