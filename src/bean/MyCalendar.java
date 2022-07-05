package bean;

import java.util.ArrayList;
import java.util.List;

/**
 * 729. 我的日程安排表 I
 * https://leetcode.cn/problems/my-calendar-i/
 */
public class MyCalendar {
    List<int[]> cache;

    public MyCalendar() {
        cache = new ArrayList<>();
    }

    // [start,end)
    public boolean book(int start, int end) {
        for (int[] item : cache) {
            int cStart = item[0];
            int cEnd = item[1];

            if (cStart >= end || cEnd <= start) {
                continue;
            }
            return false;
        }
        cache.add(new int[]{start, end});
        return true;
    }


}