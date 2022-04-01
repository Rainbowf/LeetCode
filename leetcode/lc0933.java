package leetcode;

import java.util.*;

//offer2q042

class RecentCounter {
    private Queue<Integer> times;
    private int size;

    public RecentCounter() {
        times = new LinkedList<>();
        size = 3000;
    }

    public int ping(int t) {
        times.offer(t);
        while (times.peek() + size < t){
            times.poll();
        }
        return times.size();
    }
}