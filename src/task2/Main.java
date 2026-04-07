
import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Converter converter = new Converter();
        String filename = "result.ser";

        System.out.print("Введіть число: ");
        int input = scanner.nextInt();

        CalculationResult res = converter.convert(input);
        System.out.println("\n--- Результат ---");
        System.out.println(res);

        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename))) {
            out.writeObject(res);
            System.out.println("\nЗбережено у файл!");
        } catch (IOException e) { e.printStackTrace(); }

    
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename))) {
            CalculationResult restored = (CalculationResult) in.readObject();
            System.out.println("\n--- Відновлено ---");
            System.out.println(restored);
        } catch (Exception e) { e.printStackTrace(); }
    }
}