package leetcode;

import java.util.*;

//offer2q074

class Solution0056 {
    public static void main(String[] args) {
        int[][] temp = new int[][]{{1, 3}, {2, 6}, {8, 10}, {9, 18}};
        int[][] res = merge(temp);
        for (int[] nums : res) {
            System.out.printf("%d %d", nums[0], nums[1]);
        }

    }

    //错误版本，i = j 必须放在 内循环外面，否则永远不会超值
    public static int[][] merge(int[][] intervals) {
        List<int[]> res = new ArrayList<>();

        //按照第一个排序
        Arrays.sort(intervals, Comparator.comparingInt(i -> i[0]));

        //当前
        int i = 0;
        while (i < intervals.length) {
            int curLeft = intervals[i][0];
            int curRight = intervals[i][1];

            for (int j = i + 1; j < intervals.length; ) {
                if (intervals[j][0] <= curRight) {
                    if (intervals[j][1] > curRight) {
                        curRight = intervals[j][1];
                    }
                    j++;
                } else {
                    i = j;
                    break;
                }
            }
            res.add(new int[]{curLeft, curRight});
        }
        int[][] ans = new int[res.size()][2];
        return res.toArray(ans);
    }

    //正确版本
    public int[][] merge2(int[][] intervals) {
        List<int[]> res = new ArrayList<>();

        //按照第一个排序
        Arrays.sort(intervals, (i1, i2) -> i1[0] - i2[0]);

        //当前
        int i = 0;
        while (i < intervals.length) {
            int curLeft = intervals[i][0];
            int curRight = intervals[i][1];
            int j = i + 1;
            for (; j < intervals.length; j++) {
                if (intervals[j][0] <= curRight) {
                    if (intervals[j][1] > curRight) {
                        curRight = intervals[j][1];
                    }
                } else {
                    break;
                }
            }
            i = j;
            res.add(new int[]{curLeft, curRight});
        }
        int[][] ans = new int[res.size()][2];
        return res.toArray(ans);
    }
}