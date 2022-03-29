package leetcode;

import java.util.*;

//offer2q035

class Solution0539 {
    public int findMinDifference(List<String> timePoints) {
        if (timePoints.size() > 1440) {
            return 0;
        }

        boolean[] flags = new boolean[1440];
        for (String timeStr : timePoints) {
            String[] t = timeStr.split(":");
            int time = Integer.parseInt(t[0]) * 60 + Integer.parseInt(t[1]);
            if (flags[time]) {
                return 0;
            }
            flags[time] = true;
        }
        return minDiff(flags);
    }

    private int minDiff(boolean[] flags) {
        int prev = -1;
        int res = flags.length - 1;
        int first = flags.length - 1;
        int last = -1;

        for (int i = 0; i < flags.length; i++) {
            if (flags[i]) {
                first = Math.min(first, i);
                last = Math.max(last, i);
                if(prev >= 0){
                    res = Math.min(res, i - prev);
                }
                prev = i;
            }
        }
        res = Math.min(res, flags.length - last + first);
        return res;
    }
}