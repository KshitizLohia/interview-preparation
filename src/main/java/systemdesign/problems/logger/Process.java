package systemdesign.problems.logger;

import lombok.Data;

@Data
class Process {
    private final String id;
    private final long start;
    private long end;

    public Process(final String id, final long start) {
        this.id = id;
        this.start = start;
    }
}