import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Реалізація шаблону Worker Thread для фонового виконання команд.
 */
public class QueueProcessor implements Runnable {
    // Потокобезпечна черга
    private final BlockingQueue<Command> queue = new LinkedBlockingQueue<>();
    private volatile boolean running = true;

    public void put(Command cmd) {
        try {
            queue.put(cmd);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public void stop() {
        running = false;
    }

    @Override
    public void run() {
        System.out.println("Фоновий потік запущено...");
        while (running || !queue.isEmpty()) {
            try {
                // Взяття команди з черги (чекає, якщо порожньо)
                Command cmd = queue.take();
                cmd.execute();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
        System.out.println("Фоновий потік зупинено.");
    }
}