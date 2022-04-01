package leetcode;

import java.util.*;

//offer2q058

class MyCalendar {

    private TreeMap<Integer, Integer> events;

    public MyCalendar() {
        events = new TreeMap<>();
    }

    public boolean book(int start, int end) {
        //左边
        Integer leftStart = events.floorKey(start);
        if (leftStart != null && events.get(leftStart) > start) {
            return false;
        }
        //右边
        Integer rightStart = events.ceilingKey(start);
        if (rightStart != null && rightStart < end) {
            return false;
        }
        //都没有，存进去，返回true
        events.put(start, end);
        return true;
    }
}