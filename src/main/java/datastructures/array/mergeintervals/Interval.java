package datastructures.array.mergeintervals;

import lombok.Data;

@Data
class Interval {
    private int start;
    private int end;

    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }

}
