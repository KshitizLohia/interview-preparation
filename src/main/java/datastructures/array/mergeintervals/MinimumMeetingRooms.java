package datastructures.array.mergeintervals;

import java.util.*;

/**
 * Meetings: [[1,4], [2,5], [7,9]]
 * Output: 2
 * Explanation: Since [1,4] and [2,5] overlap, we need two rooms to hold these two meetings. [7,9] can
 * occur in any of the two rooms later.
 */
public class MinimumMeetingRooms {

    public static int getMinimumMeetingRooms(List<Interval> meetingRooms) {

        // Sort all the meetings on their start time.
        Collections.sort(meetingRooms, (a, b) -> Integer.compare(a.getStart(), b.getStart()));
        int minRooms = Integer.MAX_VALUE;

        // Create a min-heap to store all the active meetings.
        // This min-heap will also be used to find the active meeting with the smallest end time.
        PriorityQueue<Interval> minHeap = new PriorityQueue<>(meetingRooms.size(),
                (a,b) -> Integer.compare(a.getEnd(), b.getEnd()));

        for (int i=0; i<meetingRooms.size(); i++) {

            Interval mi = meetingRooms.get(i);


            // Since the min-heap contains all the active meetings, so before scheduling m1 we can remove all meetings
            // from the heap that have ended before m1,
            // i.e., remove all meetings from the heap that have an end time smaller than or equal to the start time of m1.

            while (!minHeap.isEmpty() && minHeap.peek().getEnd() <= mi.getStart()) {
                minHeap.poll();
            }
            minHeap.offer(mi);
            minRooms = Math.min(minRooms, minHeap.size());
        }
        return minRooms;
    }

    public static void main(String[] args) {
        List<Interval> meetingRooms = new ArrayList<>();
        meetingRooms.add(new Interval(1, 4));
        meetingRooms.add(new Interval(2, 5));
        meetingRooms.add(new Interval(7, 9));
        System.out.println(getMinimumMeetingRooms(meetingRooms));

    }
}
