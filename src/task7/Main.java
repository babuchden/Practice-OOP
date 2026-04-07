package task7;
import java.util.Scanner;
import task4.ConverterFactory;

public class Main {
    public static void main(String[] args) {
        DataModel model = new DataModel();
        
        // Реєструємо двох спостерігачів (пункт 1 завдання)
        model.addObserver(new ConsoleObserver());
        model.addObserver(new GraphView());
        
        // Показуємо роботу рефлексії (пункт 2 завдання)
        model.showReflectionInfo();

        Scanner sc = new Scanner(System.in);
        ConverterFactory factory = new ConverterFactory();

        System.out.println("Програма запущена. Графічне вікно має відкритися.");
        
        while (true) {
            System.out.println("\n1. Додати нове значення в колекцію");
            System.out.println("0. Вихід");
            System.out.print("> ");
            
            if (sc.hasNextInt()) {
                int choice = sc.nextInt();
                if (choice == 1) {
                    // Додаємо випадкове число для демонстрації
                    model.addData(factory.createResult((int)(Math.random() * 100)));
                } else if (choice == 0) {
                    System.out.println("Завершення роботи.");
                    System.exit(0);
                }
            } else {
                sc.next(); // Очистка буфера
            }
        }
    }
}