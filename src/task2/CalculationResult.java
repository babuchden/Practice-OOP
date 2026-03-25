package task2;
import java.io.Serializable;

public class CalculationResult implements Serializable {
    private int number;
    private String binary;
    private String octal;
    private String hex;
    private transient String statusInfo; 

    public CalculationResult(int number, String binary, String octal, String hex) {
        this.number = number;
        this.binary = binary;
        this.octal = octal;
        this.hex = hex;
        this.statusInfo = "Об'єкт створено";
    }

    @Override
    public String toString() {
        return "Число: " + number + 
               "\n2-кова: " + binary + 
               "\n8-кова: " + octal + 
               "\n16-кова: " + hex +
               "\nСтатус (transient): " + statusInfo;
    }
}