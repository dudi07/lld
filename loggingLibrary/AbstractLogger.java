package loggingLibrary;

import loggingLibrary.appender.LogSubject;

public abstract class AbstractLogger {
    int level;
    AbstractLogger nextLogger;

    public void setNextLogger(AbstractLogger nextLogger) {
        this.nextLogger = nextLogger;
    }

    void logMessage(int level, String message, LogSubject logSubject){
        if(this.level <= level){
            write(message, logSubject);
        }
        if(nextLogger != null){
            nextLogger.logMessage(level, message, logSubject);
        }
    }

    protected abstract void write(String message, LogSubject logSubject);
}
