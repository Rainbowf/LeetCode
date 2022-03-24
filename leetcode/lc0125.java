package leetcode;

import java.util.*;

//offer2q018

class Solution0125 {
    public boolean isPalindrome(String s) {
        if (s.length() == 0) return true;
        int i = 0, j = s.length() - 1;
        while (i < j) {//不取=是因为单个字符必然是回文的
            char ch1 = s.charAt(i);
            char ch2 = s.charAt(j);
            if (!Character.isLetterOrDigit(ch1)) {
                i++;
            } else if (!Character.isLetterOrDigit(ch2)) {
                j--;
            } else {
                ch1 = Character.toLowerCase(ch1);
                ch2 = Character.toLowerCase(ch2);
                if (ch1 != ch2) {
                    return false;
                } else {
                    i++;
                    j--;
                }
            }
        }
        return true;
    }

    public boolean isPalindrome2(String s) {
        if (s.length() == 0) return true;
        int i = 0, j = s.length() - 1;
        s = s.toLowerCase();
        while (i < j) {//不取=是因为单个字符必然是回文的
            while (i < j && !Character.isLetterOrDigit(s.charAt(i))) {
                i++;
            }

            while (i < j && !Character.isLetterOrDigit(s.charAt(j))) {
                j--;
            }

            if (i < j) {
                if (s.charAt(i) != s.charAt(j)) {
                    return false;
                } else {
                    i++;
                    j--;
                }
            }
        }
        return true;
    }
}