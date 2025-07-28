package loggingLibrary.appender;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class AsyncAppender implements Appender {
    private final BlockingQueue<String> queue;
    private final Appender delegate;
    private final Thread worker;
    private volatile boolean running = true;

    public AsyncAppender(Appender delegate) {
        this.queue = new LinkedBlockingQueue<>();
        this.delegate = delegate;
        this.worker = new Thread(() -> {
            try {
                while (running || !queue.isEmpty()) {
                    String message = queue.take();
                    delegate.append(message);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });
        this.worker.setDaemon(true);
        this.worker.start();
    }

    @Override
    public void append(String message) {
        if (running) {
            queue.offer(message);
        }
    }

    public void shutdown() {
        running = false;
        worker.interrupt();
    }
}
