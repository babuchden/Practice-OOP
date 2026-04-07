

import java.io.*;
import java.util.Scanner;

/**
 * Клас для зберігання результатів обчислень.
 * Демонструє використання Serializable та transient.
 * @author Denys
 */
class CalculationResult implements Serializable {
    private static final long serialVersionUID = 1L;
    
    public int number;
    public String binary;
    public String octal;
    public String hex;

    /** Поле, яке не зберігається при серіалізації */
    public transient String tempStatus; 

    public CalculationResult(int n, String b, String o, String h) {
        this.number = n;
        this.binary = b;
        this.octal = o;
        this.hex = h;
        this.tempStatus = "Обчислено в поточному сеансі";
    }

    @Override
    public String toString() {
        return "Число: " + number + "\nBin: " + binary + "\nOct: " + octal + "\nHex: " + hex + 
               "\nСтатус (transient): " + tempStatus;
    }
}

/**
 * Клас для вирішення задачі (Агрегування).
 */
class Solver {
    /** Використання агрегування: клас Solver містить об'єкт результату */
    private CalculationResult result;

    public void solve(int n) {
        result = new CalculationResult(
            n, 
            Integer.toBinaryString(n), 
            Integer.toOctalString(n), 
            Integer.toHexString(n).toUpperCase()
        );
    }

    public CalculationResult getResult() {
        return result;
    }

    public void setResult(CalculationResult res) {
        this.result = res;
    }
}

/**
 * Головний клас для демонстрації роботи.
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Solver solver = new Solver();

        System.out.print("Введіть ціле число: ");
        int input = sc.nextInt();

        // 1. Обчислення
        solver.solve(input);
        System.out.println("\n--- Дані перед збереженням ---");
        System.out.println(solver.getResult());

        // 2. Збереження (Серіалізація)
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("result.ser"))) {
            out.writeObject(solver.getResult());
            System.out.println("\n[OK] Дані збережено у файл result.ser");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 3. Відновлення (Десеріалізація)
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("result.ser"))) {
            CalculationResult restored = (CalculationResult) in.readObject();
            solver.setResult(restored);
            System.out.println("\n--- Дані після відновлення (з файлу) ---");
            System.out.println(solver.getResult());
            System.out.println("(Зверни увагу: Статус став null, бо поле transient)");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}