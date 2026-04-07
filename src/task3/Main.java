import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    /** Список для зберігання результатів обчислень */
    public List<CalculationResult> results = new ArrayList<>();

    /** * Метод для додавання нового результату обчислення.
     * Вирішує помилку "The method addResult(int) is undefined".
     */
    public void addResult(int n) {
        results.add(new CalculationResult(n, Integer.toBinaryString(n), 
                    Integer.toOctalString(n), Integer.toHexString(n).toUpperCase()));
    }

    public static void main(String[] args) {
        Main app = new Main();
        Scanner sc = new Scanner(System.in);
        
        System.out.println("--- Програма переведення чисел (Task 3) ---");
        System.out.print("Введіть число для розрахунку: ");
        
        if (sc.hasNextInt()) {
            app.addResult(sc.nextInt());
        }

        System.out.println("\nОберіть спосіб відображення:");
        System.out.println("1 - Звичайний текст");
        System.out.println("2 - Текстова таблиця");
        System.out.print("Ваш вибір: ");
        int mode = sc.nextInt();

        // Створюємо фабрику, яка вирішує, який тип View повернути
        int width = 15;
        Viewable factory;
        if (mode == 2) {
            System.out.print("Введіть ширину стовпця (напр. 15): ");
            width = sc.nextInt();
            factory = new ViewableResult(true, width);
        } else {
            factory = new ViewableResult(false, width);
        }

        // Отримуємо об'єкт View через інтерфейс (Поліморфізм)
        View view = factory.getView();

        // Виведення результатів
        view.viewHeader();
        for (CalculationResult r : app.results) {
            view.viewData(r); // Це працюватиме, якщо ти оновив View.java
        }
        view.viewFooter();
        
        System.out.println("\nПрограма завершена. Натисніть 'q' для виходу у меню, якщо воно є.");
        sc.close();
    }
}