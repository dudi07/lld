package loggingLibrary.appender;

public class FileLogger implements LogObserver {

    @Override
    public void log(String message) {
        System.out.println("FILE LOGGER :: writing to file " + message);
        
    }
    
}
