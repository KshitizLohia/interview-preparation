package datastructures.array.mergeintervals;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a list of intervals, merge all the overlapping intervals to produce a list that
 * has only mutually exclusive intervals.
 *
 * Intervals: [[1,4], [2,5], [7,9]]
 * Output: [[1,5], [7,9]]
 * Explanation: Since the first two intervals [1,4] and [2,5] overlap, we merged them into
 * one [1,5].
 */

public class MergeInterval {
    public static void main(String[] args) {
        List<Interval> b = new ArrayList<>();
        b.add(new Interval(1, 4));
        b.add(new Interval(2, 5));
        b.add(new Interval(7, 9));
        List<Interval> merged =  mergeInterval(b);
        for (Interval a: merged) {
            System.out.println(a.getStart() + "-" + a.getEnd() );
        }
    }

    public static List<Interval> mergeInterval(final List<Interval> intervals) {
        List<Interval> mergedInterval = new ArrayList<>();
        int start1 = intervals.get(0).getStart();
        int end1 = intervals.get(0).getEnd();

        for (int i =1; i<intervals.size(); i++) {
            int start2 = intervals.get(i).getStart();
            int end2 = intervals.get(i).getEnd();
            if (start2 <= end1) {
                end1 = Math.max(end1, end2);
            } else {
                mergedInterval.add(new Interval(start1, end1));
                start1 = start2;
                end1 = end2;
            }
         }
        mergedInterval.add(new Interval(start1, end1));
        return mergedInterval;

    }
}

