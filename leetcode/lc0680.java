package leetcode;

import java.util.*;

//offer2q019

class Solution0680 {
    public boolean validPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        while (i < j && s.charAt(i) == s.charAt(j)) {
            i++;
            j--;
        }
        return i == s.length() / 2 + 1 || isPalindrome(s,i,j-1) || isPalindrome(s,i+1,j);
    }

    private static boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}