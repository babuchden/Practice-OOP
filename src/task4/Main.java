package task4;
import java.util.*;

public class Main {
    private List<Displayable> list = new ArrayList<>();
    private ResultFactory factory = new TableConverterFactory();

    public void menu() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\n--- ЛАБА 4: ТАБЛИЦЯ ТА ПОЛІМОРФІЗМ ---");
            System.out.println("1. Додати число");
            System.out.println("2. Вивести список (просто)");
            System.out.println("3. Вивести ТАБЛИЦЕЮ (параметри користувача)");
            System.out.println("0. Вихід");
            System.out.print("> ");
            
            int c = sc.nextInt();
            if (c == 1) {
                System.out.print("Введіть число: ");
                list.add(factory.createResult(sc.nextInt()));
            } else if (c == 2) {
                list.forEach(Displayable::display); // Поліморфізм (пізнє зв'язування)
            } else if (c == 3) {
                System.out.print("Ширина стовпця: ");
                int w = sc.nextInt();
                System.out.println("=".repeat(w * 5));
                list.forEach(item -> item.display(w)); // Виклик перевантаженого методу
                System.out.println("=".repeat(w * 5));
            } else if (c == 0) break;
        }
    }

    public static void main(String[] args) {
        new Main().menu();
    }
}