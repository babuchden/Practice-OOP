import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public List<CalculationResult> results = new ArrayList<>();
    
    public static void main(String[] args) {
        Main app = new Main();
        Scanner sc = new Scanner(System.in);
        UndoManager undoManager = UndoManager.getInstance(); // Singleton

        while (true) {
            System.out.println("\n--- MENU (Task 4) ---");
            System.out.println("1. Додати розрахунок");
            System.out.println("2. Скасувати останню дію (Undo)");
            System.out.println("3. Виконати макрокоманду (тест)");
            System.out.println("4. Показати поточні результати");
            System.out.println("0. Вихід");
            System.out.print("Вибір: ");
            
            int choice = sc.nextInt();
            if (choice == 0) break;

            switch (choice) {
                case 1:
                    System.out.print("Введіть число: ");
                    int num = sc.nextInt();
                    undoManager.execute(new CalcCommand(app, num));
                    break;
                case 2:
                    undoManager.undo();
                    break;
                case 3:
                    // Демонстрація макрокоманди
                    MacroCommand macro = new MacroCommand();
                    macro.add(new CalcCommand(app, 10));
                    macro.add(new CalcCommand(app, 20));
                    macro.add(new CalcCommand(app, 30));
                    undoManager.execute(macro);
                    break;
                case 4:
                    System.out.println("Поточні дані в списку: " + app.results.size() + " елементів.");
                    for(CalculationResult r : app.results) System.out.println(r);
                    break;
                default:
                    System.out.println("Невірний вибір.");
            }
        }
        sc.close();
    }
}