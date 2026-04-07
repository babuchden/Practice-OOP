package task6;
import java.util.*;
import task4.*;

public class Main {
    private List<Displayable> list = new ArrayList<>();
    private ResultFactory factory = new TableConverterFactory();
    private WorkerManager worker = new WorkerManager();

    public void start() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\n--- TASK 6: MULTITHREADING ---");
            System.out.println("1. Додати число");
            System.out.println("2. Запустити фонову статистику");
            System.out.println("3. Показати список");
            System.out.println("0. Вихід");
            System.out.print("> ");

            int cmd = sc.nextInt();
            if (cmd == 1) {
                System.out.print("Число: ");
                list.add(factory.createResult(sc.nextInt()));
            } else if (cmd == 2) {
                worker.execute(new StatisticsTask(list));
                System.out.println("Завдання відправлено робітнику.");
            } else if (cmd == 3) {
                list.forEach(Displayable::display);
            } else if (cmd == 0) {
                worker.stop();
                break;
            }
        }
    }

    public static void main(String[] args) {
        new Main().start();
    }
}