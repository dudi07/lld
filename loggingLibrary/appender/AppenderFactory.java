package loggingLibrary.appender;


public class AppenderFactory {
    public static Appender createAppender(String type) {
        switch (type.toLowerCase()) {
            case "console":
                return new ConsoleAppender();
            case "file":
                String filePath = System.getenv("LOG_FILE_PATH");
                if (filePath == null || filePath.isEmpty()) {
                    filePath = "default.log";
                }
                return new FileAppender(filePath); // FileAppender uses env variable or default
            // Add more appender types as needed
            default:
                throw new IllegalArgumentException("Unknown appender type: " + type);
        }
    }
}
