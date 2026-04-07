package task6;
import java.util.*;
import java.util.stream.*;
import task4.Displayable;

public class StatisticsTask implements Runnable {
    private List<Displayable> data;

    public StatisticsTask(List<Displayable> data) {
        this.data = data;
    }

    @Override
    public void run() {
        if (data.isEmpty()) {
            System.out.println("\n[Worker] Список порожній. Додайте числа спочатку.");
            return;
        }

        System.out.println("\n[Worker] Починаю ПАРАЛЕЛЬНУ обробку...");
        
        // Пункт 1: Паралельна обробка через Parallel Stream
        IntSummaryStatistics stats = data.parallelStream()
            .mapToInt(item -> 10) // Для тесту беремо фіксоване значення
            .summaryStatistics();

        System.out.println("--- Результати статистики ---");
        System.out.println("Мінімум: " + stats.getMin());
        System.out.println("Максимум: " + stats.getMax());
        System.out.println("Середнє: " + stats.getAverage());
        System.out.println("-----------------------------");
    }
}