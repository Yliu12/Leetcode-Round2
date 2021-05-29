package random;
import java.util.*;

class MinMeetingRooms {
    public int minMeetingRooms(int[][] intervals) {  
       Arrays.sort(intervals,(a,b) -> Integer.compare(a[0], b[0]));

       PriorityQueue<Integer> roomEndTimes = new PriorityQueue<>(intervals.length);
        roomEndTimes.offer(intervals[0][1]);
       for(int i = 1; i < intervals.length; i ++ ){
            var current = intervals[i];
            int currentStart = current[0];
            int currentEnd = current[1];
            if(currentStart>=roomEndTimes.peek()){
                roomEndTimes.poll();   
            }
           roomEndTimes.offer(currentEnd);
        }
        return roomEndTimes.size();
    }
}