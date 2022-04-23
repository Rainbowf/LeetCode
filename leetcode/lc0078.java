package leetcode;

import java.util.*;

//offer2q079

class Solution0078 {
    public List<List<Integer>> subsets(int[] nums) {
        //创建结果数组
        List<List<Integer>> res = new LinkedList<>();
        LinkedList<Integer> subset = new LinkedList<>();

        helper(nums, 0, res, subset);
        return res;
    }

    private void helper(int[] nums, int i, List<List<Integer>> res, LinkedList<Integer> subset) {
        if (i == nums.length) {
            res.add(new LinkedList<>(subset));
        } else if (i < nums.length) {
            //不放
            helper(nums, i + 1, res, subset);
            //放
            subset.add(nums[i]);
            helper(nums, i + 1, res, subset);
            subset.removeLast();//放后取出来
        }
    }
}