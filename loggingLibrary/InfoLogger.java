package loggingLibrary;

import loggingLibrary.appender.LogSubject;

public class InfoLogger extends AbstractLogger {

    public InfoLogger(int level){
        this.level = level;
    }
    @Override
    protected void write(String message, LogSubject logSubject) {
        logSubject.notifyAllLogObservers(1, message);
    }
    
}
