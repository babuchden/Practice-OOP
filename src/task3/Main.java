package task3;
import java.io.*;
import java.util.*;

public class Main {
    private List<Displayable> results = new ArrayList<>();
    private ResultFactory factory = new ConverterFactory();
    private final String FILE_NAME = "results.dat";

    public void showMenu() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\n--- МЕНЮ ---");
            System.out.println("1. Додати число");
            System.out.println("2. Показати список");
            System.out.println("3. Зберегти у файл");
            System.out.println("4. Завантажити з файлу");
            System.out.println("0. Вихід");
            System.out.print("> ");
            
            int choice = sc.nextInt();
            if (choice == 1) {
                System.out.print("Число: ");
                results.add(factory.createResult(sc.nextInt()));
            } else if (choice == 2) {
                results.forEach(Displayable::display);
            } else if (choice == 3) {
                saveData();
            } else if (choice == 4) {
                loadData();
            } else if (choice == 0) {
                break;
            }
        }
    }

    private void saveData() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(results);
            System.out.println("Успішно збережено.");
        } catch (IOException e) {
            System.out.println("Помилка збереження.");
        }
    }

    private void loadData() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            results = (List<Displayable>) ois.readObject();
            System.out.println("Дані відновлено.");
        } catch (Exception e) {
            System.out.println("Файл не знайдено або помилка.");
        }
    }

    public static void main(String[] args) {
        new Main().showMenu();
    }
}