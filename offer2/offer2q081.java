package offer2;

import java.util.*;
//0039
//0040
class Solution081 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
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
            helper(candidates, i + 1, target, comb, res);

            comb.add(candidates[i]);
            helper(candidates, i, target - candidates[i], comb, res);
            comb.removeLast();
        }
    }
}