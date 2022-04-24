package leetcode;

import java.util.*;
//offer2q082
//优化了
class Solution0040 {
    private int[] dp;
    private int[] counts;

    //计数排序
    public int[] countSort(int[] arr) {
        //遍历arr
        counts = new int[51];
        for (int num : arr) {
            counts[num]++;
        }
        //遍历counts
        int i = 0;
        int temp = 0;
        for (int num = 1; num < counts.length; num++) {
            temp += counts[num];
            while (counts[num] > 0) {
                arr[i] = num;
                dp[i] = temp;
                counts[num]--;
                i++;
            }
        }
        return arr;
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new LinkedList<>();
        LinkedList<Integer> comb = new LinkedList<>();
        dp = new int[candidates.length];
        countSort(candidates);

        helper(0, target, candidates, res, comb);
        return res;
    }

    private void helper(int i, int target, int[] candidates, List<List<Integer>> res, LinkedList<Integer> comb) {
        if (target == 0) {
            res.add(new LinkedList<>(comb));
        } else if (i < candidates.length && target > 0) {
            helper(dp[i], target, candidates, res, comb);

            if (target - candidates[i] >= 0) {
                comb.add(candidates[i]);
                helper(i + 1, target - candidates[i], candidates, res, comb);
                comb.removeLast();
            }
        }
    }
}