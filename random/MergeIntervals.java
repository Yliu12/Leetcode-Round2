package random;

import java.util.*;

class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        LinkedList<int[]> list = new LinkedList<int[]>();
        list.offer(intervals[0]);
        for (int[] interval : intervals) {
            var last = list.getLast();
            if (last[1] >= interval[0]) {
                list.getLast()[1] = Math.max(last[1], interval[1]);
            } else {
                list.offer(interval);
            }

        }
        return list.toArray(new int[list.size()][2]);
    }
}