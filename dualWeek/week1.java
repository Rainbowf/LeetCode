package dualWeek;

import java.util.*;
import java.util.Arrays;

class Solutionweek1 {
//    public static void main(String[] args) {
//        double[][] nums1;
//        System.out.println((nums1));
//        Arrays.sort(nums1, (l1,l2)->({
//            if(l1[0] == l2[0]){
//                return l2[1] - l1[1];
//            }else {
//                return l1[0] == l2[0];
//            }});
//    }



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