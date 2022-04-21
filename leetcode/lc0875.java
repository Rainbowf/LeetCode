package leetcode;

import java.util.*;

//offer2q073

class Solution0875 {
    public int minEatingSpeed(int[] piles, int h) {

        Arrays.sort(piles);
        //二分
        int i = 1;
        int j = piles[piles.length - 1];
        while (i <= j) {
            int m = i + (j - i) / 2;
            if (getHours(piles, m) <= h) {
                if (m == 1 || getHours(piles, m - 1) > h) {
                    return m;
                }
                j = m - 1;
            } else {
                i = m + 1;
            }
        }
        return -1;
    }


    private int getHours(int[] piles, int speed) {
        int res = 0;
        for (int pile : piles) {
            res += (pile - 1) / speed + 1;
        }
        return res;
    }
}