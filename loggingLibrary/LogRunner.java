package loggingLibrary;

public class LogRunner {
    public static void main(String[] args) {
        Logger logger = Logger.getInstance();
        logger.errorLog("this is Error");
    }
}
