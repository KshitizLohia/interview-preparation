package datastructures.array.mergeintervals;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a list of non-overlapping intervals sorted by their start time, insert a given interval at the correct position
 * and merge all necessary intervals to produce a list that has only mutually exclusive intervals
 *
 * Input: Intervals=[[1,3], [5,7], [8,12]], New Interval=[4,6]
 * Output: [[1,3], [4,7], [8,12]]
 * Explanation: After insertion, since [4,6] overlaps with [5,7], we merged them into one [4,7].
 */
public class InsertInterval {

    public static List<Interval> insertInterval(List<Interval> intervals, Interval addInterval) {
        int i=0;
        int start = addInterval.getStart();
        int end = addInterval.getEnd();
        List<Interval> mergedInterval = new ArrayList<>();
        // find index i
        while (i < intervals.size() && end >= intervals.get(i).getStart()) {
            mergedInterval.add(intervals.get(i));
            i++;
        }
        // insert
        while (i < intervals.size() && end >= intervals.get(i).getStart()) {
            addInterval.setEnd( Math.max(intervals.get(i).getEnd(), end));
            addInterval.setStart(Math.min(intervals.get(i).getStart(), start));
            i++;
        }
        mergedInterval.add(addInterval);

        // continue with the rest
        while (i < intervals.size()) {
            mergedInterval.add(intervals.get(i));
            i++;
        }
        return mergedInterval;
    }

    public static void main(String[] args) {
        List<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(1, 3));
        intervals.add(new Interval(5, 7));
        intervals.add(new Interval(8, 12));

        Interval addInterval = new Interval(4, 6);
        insertInterval(intervals, addInterval);

    }
}
