package dualWeek;

import java.util.*;


class Solutionweek1 {
    public static void main(String[] args) {
        double[] nums1 = {3,3,3,3};
        System.out.println((nums1));
    }



    public static int countPairs(int[] nums, int k) {
        int res = 0;
        //暴力解法100*100
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j] && (i * j) % k == 0) {
                    res++;
                }
            }
        }
        return res;
    }


}