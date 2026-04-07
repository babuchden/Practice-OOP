
import java.io.*;
import java.util.*;

public class Main {
    private List<CalculationResult> results = new ArrayList<>();

    public void addResult(int n) {
        results.add(new CalculationResult(n, Integer.toBinaryString(n), 
                    Integer.toOctalString(n), Integer.toHexString(n).toUpperCase()));
    }

    public void save() throws IOException {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("results.ser"))) {
            out.writeObject(results);
        }
    }

    public void load() throws Exception {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("results.ser"))) {
            results = (List<CalculationResult>) in.readObject();
        }
    }

    public static void main(String[] args) throws Exception {
        Main app = new Main();
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Введіть перше число: ");
        app.addResult(sc.nextInt());
        System.out.print("Введіть друге число: ");
        app.addResult(sc.nextInt());

        // Використання Factory Method
        ViewFactory factory = new TextViewFactory();
        View view = factory.createView();

        view.viewHeader();
        view.viewBody();
        for (CalculationResult res : app.results) {
            view.viewData(res);
        }
        view.viewFooter();

        app.save();
        System.out.println("\n[Система] Колекцію збережено. Очищуємо та завантажуємо назад...");
        app.load();
        System.out.println("[Система] Відновлено об'єктів: " + app.results.size());
    }
}