package offer2;

import java.util.*;

class Solution085 {
    public List<String> generateParenthesis(int n) {
        List<String> res = new LinkedList<>();
        helper(n, n, "", res);
        return res;
    }

    private void helper(int l, int r, String s, List<String> res) {
        if (l == 0 && r == 0) {
            res.add(s);
        }
        if (l > 0) {
            helper(l - 1, r, s + "(", res);
        }
        if (l < r) {
            helper(l, r - 1, s + ")", res);
        }
    }
}