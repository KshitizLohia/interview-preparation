package systemdesign.problems.logger;

public interface Logger {
    /**
     * When the process starts, it calls start with process id
     * @param processId process id
     */
    void start(String processId);

    /**
     * When the process ends, it calls end with process id
     * @param processId
     */
    void end(String processId);

    /**
     * Polls the first entry of completed process sorted by start time and log it
     * {processId} started at {startTime} and ended at {endTime}
     */
    void poll();
}
