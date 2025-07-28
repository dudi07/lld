package loggingLibrary.appender;

import java.io.File;

public class FileAppender implements Appender {
    private final String filePath;
    private static final long MAX_FILE_SIZE = 1024 * 1024; // 1MB

    public FileAppender(String filePath) {
        this.filePath = filePath;
    }

    private String getRotatedFilePath() {
        File file = new File(filePath);
        if (!file.exists() || file.length() < MAX_FILE_SIZE) {
            return filePath;
        }
        int index = 1;
        String baseName = filePath;
        String ext = "";
        int dot = filePath.lastIndexOf('.');
        if (dot != -1) {
            baseName = filePath.substring(0, dot);
            ext = filePath.substring(dot);
        }
        String newPath;
        do {
            newPath = baseName + "_" + index + ext;
            index++;
        } while (new File(newPath).exists() && new File(newPath).length() >= MAX_FILE_SIZE);
        return newPath;
    }

    @Override
    public void append(String message) {
        String targetPath = getRotatedFilePath();
        try (java.io.FileWriter writer = new java.io.FileWriter(targetPath, true)) {
            writer.write(message + System.lineSeparator());
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
    }
}