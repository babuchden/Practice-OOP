import java.io.Serializable;

/**
 * Клас для зберігання результатів обчислень.
 * Реалізує Serializable для можливості збереження стану об'єкта.
 */
public class CalculationResult implements Serializable {
    private static final long serialVersionUID = 1L;
    
    // Поле number має бути приватним, тому нам потрібен getter
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

    /**
     * Метод-геттер, який вимагає Parallel Stream у Main.java
     */
    public int getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return String.format("Число: %d | Bin: %s | Oct: %s | Hex: %s", 
                              number, binary, octal, hex);
    }
}