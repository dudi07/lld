package loggingLibrary;

import loggingLibrary.appender.ConsoleLogger;
import loggingLibrary.appender.FileLogger;
import loggingLibrary.appender.LogObserver;
import loggingLibrary.appender.LogSubject;

public class LogManager {

    protected static AbstractLogger buildChainOfLogger(){
        AbstractLogger infoLogger = new InfoLogger(1);
        AbstractLogger errorLogger = new ErrorLogger(2);
        AbstractLogger debugLogger = new DebugLogger(3);


        infoLogger.setNextLogger(errorLogger);
        errorLogger.setNextLogger(debugLogger);


        return infoLogger;
    }


    protected static LogSubject getLogSubject(){
        LogSubject logSubject = new LogSubject();

        ConsoleLogger consoleLogger = new ConsoleLogger();
        FileLogger fileLogger = new FileLogger();

        logSubject.addObserver(1, consoleLogger);
        logSubject.addObserver(2, fileLogger);


        return logSubject;
    }
    
}
