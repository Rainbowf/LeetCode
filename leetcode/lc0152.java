package leetcode;

import java.util.*;

//https://leetcode-cn.com/problems/maximum-product-subarray/solution/cheng-ji-zui-da-zi-shu-zu-by-leetcode-solution/401902
class Solution0152 {
    public int maxProduct(int[] nums) {
        int len = nums.length;
        int[] maxP = new int[len];
        int[] minP = new int[len];
        int res;
        maxP[0] = minP[0] = res = nums[0];
        for(int i = 1; i < len; i++){
            int curNum = nums[i];
            maxP[i] = Math.max(   curNum, Math.max(   curNum * maxP[i-1], curNum * minP[i-1]  ));
            minP[i] = Math.min(   curNum, Math.min(   curNum * maxP[i-1], curNum * minP[i-1]  ));
            res = Math.max(  res,  maxP[i]  );
        }
        return res;
    }
    //滚动数组，优化
    public int maxProduct2(int[] nums) {
        int maxF = nums[0], minF = nums[0], ans = nums[0];
        int length = nums.length;
        for (int i = 1; i < length; ++i) {
            int mx = maxF, mn = minF;
            maxF = Math.max(mx * nums[i], Math.max(nums[i], mn * nums[i]));
            minF = Math.min(mn * nums[i], Math.min(nums[i], mx * nums[i]));
            ans = Math.max(maxF, ans);
        }
        return ans;
    }
}



