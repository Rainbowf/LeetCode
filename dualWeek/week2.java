package dualWeek;

import java.util.*;

class Solutionweek2 {
    public static void main(String[] args) {
        double[] nums1 = {3};
        System.out.print(calculate(nums1));
    }

    public static long calculate(double[] nums) {
        double len = nums.length;

        if (len == 0) return 0;//抛出异常

        boolean isOdd = true;
        long res = 0;

        for (int i = 0; i < len; i++) {
            if (nums[i] < 0) {
                isOdd = !isOdd;
                nums[i] = -nums[i];
            } else if (nums[i] == 0) {
                return 0;
            }
            res += Math.log(nums[i]);
        }
        res = (long) Math.pow(10, res / len);

        if (len % 2 == 1 || isOdd) {
            return isOdd ? res : -res;
        } else {
            return 0;//抛出异常
        }
    }
//    public static long[] sumOfThree(long num) {
//        long n = (num / 3) - 1;
//        if (3 * (n + 1) == num) {
//            return new long[]{n, n + 1, n + 2};
//        }
//        return new long[]{};
//    }
}