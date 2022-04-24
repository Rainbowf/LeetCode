package leetcode;

import java.util.*;
//offer2q084


class Solution0047 {
    public List<List<Integer>> permute(int[] nums) {
        //结果
        List<List<Integer>> res = new LinkedList<>();
        helper(nums, 0, res);
        return res;
    }

    private void helper(int[] nums, int i, List<List<Integer>> res) {
        if (i == nums.length) {
            List<Integer> temp = new LinkedList<>();
            for (int num : nums) {
                temp.add(num);
            }
            res.add(temp);
        } else {
            Set<Integer> set = new HashSet<>();
            for (int j = i; j < nums.length; j++) {
                if(!set.contains(nums[j])){
                    set.add(nums[j]);

                    swap(nums, i, j);
                    helper(nums, i + 1, res);
                    swap(nums, i, j);
                }
            }
        }
    }

    private void swap(int[] nums, int i1, int i2) {
        if (i1 != i2) {
            int temp = nums[i1];
            nums[i1] = nums[i2];
            nums[i2] = temp;
        }
    }
}