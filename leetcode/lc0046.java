package leetcode;

import java.util.*;
//offer2q083

class Solution0046 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> pers = new LinkedList<>();

        helper(0, pers, nums);

        return pers;
    }

    private void helper(int i, List<List<Integer>> pers, int[] nums) {
        if (i == nums.length) {
            List<Integer> per = new LinkedList<>();
            for (int num : nums) {
                per.add(num);
            }
            pers.add(per);
        } else {
            for (int j = i; j < nums.length; j++) {
                swap(nums, i, j);
                helper(i + 1, pers, nums);
                swap(nums, i, j);
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