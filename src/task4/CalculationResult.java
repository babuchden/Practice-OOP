import java.io.Serializable;

public class CalculationResult implements Serializable {
    private static final long serialVersionUID = 1L;
    public int number;
    public String binary;
    public String octal;
    public String hex;

    public CalculationResult(int n, String b, String o, String h) {
        this.number = n;
        this.binary = b;
        this.octal = o;
        this.hex = h;
    }

    @Override
    public String toString() {
        return "Число: " + number + " | Bin: " + binary + " | Oct: " + octal + " | Hex: " + hex;
    }
}