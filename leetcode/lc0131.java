//131. 分割回文串
package leetcode;

import java.util.*;

class Solution0131 {
    public List<List<String>> partition(String s) {
        //1.根据返回值类型创建结果变量
        List<List<String>> res = new LinkedList<>();
        //2.创建临时变量（可不创）
        //3.调用递归函数，写出递归方程
        helper(s, 0, res, new LinkedList<String>());
        return res;
    }

    private void helper(String s, int i, List<List<String>> res, LinkedList<String> temp) {
        //递归终止条件
        if (i == s.length()) {
            res.add(new LinkedList<>(temp));
        }
        //递归继续
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
}