import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.IntSummaryStatistics;

public class Main {
    // Список результатів для статистики
    public List<CalculationResult> results = new ArrayList<>();

    /**
     * Метод для паралельної обробки елементів колекції (Stream API)
     */
    public void showParallelStatistics() {
        if (results.isEmpty()) {
            System.out.println("Колекція порожня. Додайте дані.");
            return;
        }

        // Використання паралельного потоку для обчислення статистики
        IntSummaryStatistics stats = results.parallelStream()
                .mapToInt(CalculationResult::getNumber)
                .summaryStatistics();

        System.out.println("\n--- Паралельна статистична обробка ---");
        System.out.println("Кількість елементів: " + stats.getCount());
        System.out.println("Максимум: " + stats.getMax());
        System.out.println("Мінімум: " + stats.getMin());
        System.out.println("Середнє значення: " + String.format("%.2f", stats.getAverage()));
        System.out.println("Сума всіх чисел: " + stats.getSum());
    }

    public static void main(String[] args) {
        Main app = new Main();
        Scanner sc = new Scanner(System.in);
        UndoManager undoManager = UndoManager.getInstance();

        // Ініціалізація та запуск Worker Thread
        QueueProcessor processor = new QueueProcessor();
        Thread workerThread = new Thread(processor);
        workerThread.start();

        while (true) {
            System.out.println("\n--- MENU (Task 5: Worker Thread & Parallel Stream) ---");
            System.out.println("1. Додати розрахунок (у фонову чергу)");
            System.out.println("2. Скасувати останню дію (Undo)");
            System.out.println("3. Виконати паралельну статистику (Parallel Stream)");
            System.out.println("4. Показати всі результати");
            System.out.println("0. Вихід");
            System.out.print("Вибір: ");

            int choice = sc.nextInt();
            if (choice == 0) {
                processor.stop();
                break;
            }

            switch (choice) {
                case 1:
                    System.out.print("Введіть число: ");
                    int num = sc.nextInt();
                    // Створюємо команду і кладемо в чергу (Worker Thread її виконає)
                    Command cmd = new CalcCommand(app, num);
                    processor.put(cmd);
                    // Також додаємо в історію для Undo
                    undoManager.addHistory(cmd);
                    break;
                case 2:
                    undoManager.undo();
                    break;
                case 3:
                    app.showParallelStatistics();
                    break;
                case 4:
                    app.results.forEach(System.out::println);
                    break;
                default:
                    System.out.println("Невірний вибір.");
            }
        }
        
        System.out.println("Завершення...");
        sc.close();
    }
}