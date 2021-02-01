package systemdesign.problems.logger;

import java.util.HashMap;
import java.util.Map;

class LoggerImpl implements Logger {

    private final Map<String, Process> processList;

    LoggerImpl() {
        this.processList = new HashMap<String, Process>();
    }

    public void start(String processId) {
        processList.put(processId, new Process(processId, System.currentTimeMillis()));
    }

    public void end(String processId) {
        processList.get(processId).setEnd(System.currentTimeMillis());
    }

    public void poll() {

    }
}