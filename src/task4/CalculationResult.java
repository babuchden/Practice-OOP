package task4;
import java.io.Serializable;

/** @author Denys */
public class CalculationResult implements Serializable, Displayable {
    private int number;
    private String bin, oct, hex;

    public CalculationResult(int number, String bin, String oct, String hex) {
        this.number = number;
        this.bin = bin;
        this.oct = oct;
        this.hex = hex;
    }

    @Override // ЗАМІЩЕННЯ (Overriding)
    public void display() {
        System.out.println("Число: " + number + " | Bin: " + bin);
    }

    @Override // ПЕРЕВИНАЧЕННЯ для таблиці
    public void display(int width) {
        String format = "| %-" + width + "d | %-" + width + "s | %-" + width + "s | %-" + width + "s |%n";
        System.out.printf(format, number, bin, oct, hex);
    }
}