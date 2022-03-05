package offer2;

import java.util.*;

//0039
//0040
class Solution082 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        //排序
        Arrays.sort(candidates);
        //结果
        List<List<Integer>> res = new LinkedList<>();
        LinkedList<Integer> comb = new LinkedList<>();
        helper(candidates, 0, target, comb, res);

        return res;
    }

    private void helper(int[] candidates, int i, int target, LinkedList<Integer> comb, List<List<Integer>> res) {
        if (target == 0) {
            res.add(new LinkedList<>(comb));
        } else if (i < candidates.length && target > 0) {
            //不取，直接下一个
            helper(candidates, getNext(candidates, i), target, comb, res);

            comb.add(candidates[i]);
            helper(candidates, i + 1, target - candidates[i], comb, res);
            comb.removeLast();
        }
    }

    private int getNext(int[] nums, int index) {
        int next = index;
        while (next < nums.length && nums[next] == nums[index]) {
            next++;
        }
        return next;
    }
}