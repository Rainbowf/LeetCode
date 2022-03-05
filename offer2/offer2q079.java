package offer2;

import java.util.*;

class Solution079 {
    public List<List<Integer>> subsets(int[] nums) {
        //创建结果数组
        List<List<Integer>> res = new LinkedList<>();
        LinkedList<Integer> subset =  new LinkedList<>();

        if (nums.length == 0) {
            return res;
        }

        helper(nums, 0, subset, res);
        return res;
    }

    private void helper(int[] nums, int i, LinkedList<Integer> subset, List<List<Integer>> res) {
        if (i == nums.length) {
            res.add(new LinkedList<Integer>(subset));
        } else if (i < nums.length) {
            //不放
            helper(nums, i + 1, subset, res);
            //放
            subset.add(nums[i]);
            helper(nums, i + 1, subset, res);
            subset.removeLast();//放后取出来
        }
    }

    //labuladong
    List<List<Integer>> res;
    LinkedList<Integer> track;

    public List<List<Integer>> subsets2(int[] nums) {
        res = new LinkedList<>();
        track = new LinkedList<>();
        backtrack(nums, 0, track);
        return res;
    }

    private void backtrack(int[] nums, int start, LinkedList<Integer> track) {
        res.add(new LinkedList<Integer>(track));
        for (int i = start; i < nums.length; i++) {
            track.add(nums[i]);

            backtrack(nums, i + 1, track);

            track.removeLast();
        }
    }
}