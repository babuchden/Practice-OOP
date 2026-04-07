

public class Converter {
    public CalculationResult convert(int value) {
        String bin = Integer.toBinaryString(value);
        String oct = Integer.toOctalString(value);
        String hex = Integer.toHexString(value).toUpperCase();
        return new CalculationResult(value, bin, oct, hex);
    }
}