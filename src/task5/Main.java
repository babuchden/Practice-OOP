package task5;
import java.util.*;
import task4.*;

public class Main {
    private List<Displayable> results = new ArrayList<>();
    private ResultFactory factory = new TableConverterFactory();
    private CommandManager manager = CommandManager.getInstance();

    public void menu() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\n--- TASK 5: UNDO & SINGLETON ---");
            System.out.println("1. Додати число");
            System.out.println("2. МАКРО: Додати 10, 20, 30");
            System.out.println("3. Скасувати (UNDO)");
            System.out.println("4. Показати все");
            System.out.println("0. Вихід");
            System.out.print("> ");

            int c = sc.nextInt();
            if (c == 1) {
                System.out.print("Число: ");
                manager.execute(new AddCommand(results, factory, sc.nextInt()));
            } else if (c == 2) {
                MacroCommand macro = new MacroCommand();
                macro.add(new AddCommand(results, factory, 10));
                macro.add(new AddCommand(results, factory, 20));
                macro.add(new AddCommand(results, factory, 30));
                manager.execute(macro);
                System.out.println("Макрокоманда виконана.");
            } else if (c == 3) {
                manager.undo();
                System.out.println("Останню дію скасовано.");
            } else if (c == 4) {
                results.forEach(Displayable::display);
            } else if (c == 0) break;
        }
    }

    public static void main(String[] args) {
        new Main().menu();
    }
}