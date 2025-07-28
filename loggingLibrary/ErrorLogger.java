package loggingLibrary;

import loggingLibrary.appender.LogSubject;

public class ErrorLogger extends AbstractLogger{
    public ErrorLogger(int level){
        this.level = level;
    }
    @Override
    protected void write(String message, LogSubject logSubject) {
        logSubject.notifyAllLogObservers(2, message);
    }
    
}
