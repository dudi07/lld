package loggingLibrary;

import loggingLibrary.appender.LogSubject;

public class DebugLogger extends AbstractLogger{

    public DebugLogger(int level){
        this.level = level;
    }
    @Override
    protected void write(String message, LogSubject logSubject) {
        logSubject.notifyAllLogObservers(3, message);
    }
    
}
