package leetcode;

import java.util.*;

//offer2q072

class Solution0069 {
    public int mySqrt(int x) {
        //二分查找
        int i = 1;
        int j = x;
        while (i <= j) {
            int m = i + (j - i) / 2;
            if (m <= x / m) {
                if (m == x || (m + 1) > x / (m + 1)) {
                    return m;
                }
                i = m + 1;
            } else {
                j = m - 1;
            }
        }
        return 0;
    }
}