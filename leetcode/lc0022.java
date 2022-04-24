package leetcode;

import java.util.*;
//offer2q085

class Solution0022 {
    public List<String> generateParenthesis(int n) {
        List<String> res = new LinkedList<>();
        helper(res, n, n, "");
        return res;
    }

    private void helper(List<String> res, int l, int r, String s) {
        if (l == 0 && r == 0) {
            res.add(s);
        }
        //“(”只需要有就行
        if (l > 0) {
            helper(res, l - 1, r, s + "(");
        }
        if (l < r) {
            helper(res, l, r - 1, s + ")");
        }
    }
}