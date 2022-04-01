package leetcode;

import java.util.*;

//offer2q057

class Solution0220 {
    //TreeSet
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Long> set = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            //在i-k~i的范围内找到小于等于nums[i]的最大的数，检验差值是否符合要求
            Long lower = set.floor((long) nums[i]);
            if (lower != null && lower >= (long) nums[i] - t) {
                return true;
            }
            //在i-k~i的范围内找到小于等于nums[i]的最大的数，检验差值是否符合要求
            Long upper = set.ceiling((long) nums[i]);
            if (upper != null && upper <= (long) nums[i] + t) {
                return true;
            }
            //都没有的话，就把数添加到集合里
            set.add((long) nums[i]);
            //把<=i - k 的都删掉
            if (i >= k) {
                set.remove((long) nums[i - k]);
            }
        }
        return false;
    }
    //分桶法

}
