//131. 分割回文串
package leetcode;

import java.util.*;
//offer2q086

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

class Solution0131v2 {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        for(int i = 0; i < len; i++){
            prePro(s, i, i, dp);
            prePro(s, i, i + 1, dp);
        }
        helper(res, new ArrayList<>(), s, 0, dp);
        return res;
    }

    //进行预处理，利用中心扩展 将所有回文子串的位置存储到 dp 中
    private void prePro(String s, int left , int right, boolean[][] dp){
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            dp[left][right] = true;
            left--;
            right++;
        }
    }

    private void helper(List<List<String>> res, List<String> list, String s, int index, boolean[][] dp){
        if(index == s.length()){
            res.add(new ArrayList<>(list));
            return;
        }
        for(int i = index; i < s.length(); i++){
            //利用预处理结果就不用再去判断该字符串是否是回文串
            if(!dp[index][i]){
                continue;
            }
            list.add(s.substring(index, i + 1));
            helper(res, list, s, i + 1, dp);
            list.remove(list.size() - 1);
        }
    }
}