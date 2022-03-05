package leetcode;

import java.util.*;

class Solution0017 {
    public List<String> letterCombinations(String digits) {
        List<String> res = new LinkedList<>();

        if (digits.length() == 0) {
            return res;
        }

        StringBuffer temp = new StringBuffer();
        Map<Character, String> phoneMap = new HashMap<Character, String>() {{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};
        helper(digits, 0, res, temp, phoneMap);
        return res;
    }

    private void helper(String digits, int i, List<String> res, StringBuffer temp, Map<Character, String> phoneMap) {
        if (temp.length() == digits.length()) {
            res.add(temp.toString());//深拷贝还是浅拷贝
        } else if (temp.length() < digits.length() && i < digits.length()) {
            helper(digits, i + 1, res, temp, phoneMap);

            char num = digits.charAt(i);
            for (char ch : phoneMap.get(num).toCharArray()) {
                temp.append(ch);
                helper(digits, i + 1, res, temp, phoneMap);
                temp.deleteCharAt(temp.length() - 1);
            }
        }
    }
}