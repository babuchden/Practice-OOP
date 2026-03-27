package task3;
import java.io.Serializable;

/** @author Denys */
public class CalculationResult implements Serializable, Displayable {
    private int number;
    private String binary;
    private String octal;
    private String hex;

    public CalculationResult(int number, String binary, String octal, String hex) {
        this.number = number;
        this.binary = binary;
        this.octal = octal;
        this.hex = hex;
    }

    @Override
    public void display() {
        System.out.println("Число: " + number + " [Bin: " + binary + ", Oct: " + octal + ", Hex: " + hex + "]");
    }
}