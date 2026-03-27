package task4;

public class ConverterFactory implements ResultFactory {
    @Override
    public Displayable createResult(int number) {
        return new CalculationResult(
            number, 
            Integer.toBinaryString(number), 
            Integer.toOctalString(number), 
            Integer.toHexString(number).toUpperCase()
        );
    }
}