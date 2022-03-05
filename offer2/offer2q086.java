package offer2;

import java.util.*;

class Solution086 {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new LinkedList<>();

        helper(s, 0, res, new LinkedList<String>());
        return res;
    }

    private void helper(String s, int i, List<List<String>> res, LinkedList<String> temp) {
        if (i == s.length()) {
            res.add(new LinkedList<>(temp));
        }

        for (int j = i; j < s.length(); j++) {
            if (isPalindrome(s, i, j)) {
                temp.add(s.substring(i, j + 1));//左闭右开
                helper(s, j + 1, res, temp);
                temp.removeLast();
            }
        }
    }

    //判断是否是回文串,左闭右闭
    private boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start++) != s.charAt(end--)) {
                return false;
            }
        }
        return true;
    }

    //采用动态规划，判断区间【i,j】是否回文
    private boolean[][] f;
    public void buildDP(String s){
        int n = s.length();
        f = new boolean[n][n];
        for (int i = 0; i < n; ++i) {
            Arrays.fill(f[i], true);
        }

        for (int i = n - 1; i >= 0; --i) {
            for (int j = i + 1; j < n; ++j) {
                f[i][j] = (s.charAt(i) == s.charAt(j)) && f[i + 1][j - 1];
            }
        }
    }
    //采用记忆化搜索
}
