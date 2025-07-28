package loggingLibrary;

import loggingLibrary.appender.LogSubject;

public class Logger implements Cloneable , java.io.Serializable {
    private volatile static Logger instance;
    private volatile static AbstractLogger chainOfLogger;
    private volatile static LogSubject subject;
    private Logger(){
        if(instance != null){
            throw new IllegalStateException("Logger instance already exists. Use getInstance() method.");
        }
    }
    public static Logger getInstance() {
        if (instance == null) {
            synchronized (Logger.class) {
                if (instance == null) {
                    instance = new Logger();
                    chainOfLogger = LogManager.buildChainOfLogger();
                    subject = LogManager.getLogSubject();
                }
            }
        }
        return instance;
    }
    protected Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException("Logger cannot be cloned.");
    }

    protected Object readResolve() {
        return getInstance();
    }

    private void createLog(int level, String message){
        chainOfLogger.logMessage(level, message, subject);
    }

    public void infoLog(String message){
        createLog(1, message);
    }

    public void errorLog(String message){
        createLog(2, message);
    }

    public void debugLog(String message){
        createLog(3, message);
    }
}
