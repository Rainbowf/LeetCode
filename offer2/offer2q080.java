package offer2;

import java.util.*;

class Solution080 {

    private List<List<Integer>> result;
    private LinkedList<Integer> comb;

    public List<List<Integer>> combine(int n, int k) {
        result = new LinkedList<>();
        comb = new LinkedList<>();
        helper(n, k, 1);
        return result;
    }

    private void helper(int n, int k, int i) {
        if (comb.size() == k) {
            result.add(new LinkedList<>(comb));
        } else if (i <= n) {
            helper(n, k, i + 1);

            comb.add(i);
            helper(n, k, i + 1);
            comb.removeLast();
        }
    }
}