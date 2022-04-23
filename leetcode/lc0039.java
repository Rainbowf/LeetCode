package leetcode;

import java.util.*;
//offer2q081

class Solution0039 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new LinkedList<>();
        LinkedList<Integer> comb = new LinkedList<>();
        helper(0, target, candidates, res, comb);
        return res;
    }

    private void helper(int i, int target, int[] candidates, List<List<Integer>> res, LinkedList<Integer> comb) {
        if (target == 0) {
            res.add(new LinkedList<>(comb));
        } else if (i < candidates.length && target > 0) {
            helper(i + 1, target, candidates, res, comb);
            if (target - candidates[i] >= 0) {
                comb.add(candidates[i]);
                helper(i, target - candidates[i], candidates, res, comb);
                comb.removeLast();
            }
        }
    }
}