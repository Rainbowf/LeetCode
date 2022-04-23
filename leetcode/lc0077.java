package leetcode;

import java.util.*;

//offer2q080

class Solution0077 {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> combs = new LinkedList<>();
        LinkedList<Integer> comb = new LinkedList<>();
        helper(1, n, k, combs, comb);
        return combs;
    }
    //优化剪枝
    private void helper(int i, int n, int k, List<List<Integer>> combs, LinkedList<Integer> comb) {
        if (comb.size() == k) {
            combs.add(new LinkedList<>(comb));
        } else if (i <= n && (n - i + 1) >= (k - comb.size())) {
            helper(i + 1, n, k, combs, comb);

            comb.add(i);
            helper(i + 1, n, k, combs, comb);
            comb.removeLast();
        }
    }
}