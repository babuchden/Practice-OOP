public class CalcCommand implements Command {
    private Main receiver;
    private int number;
    private CalculationResult result;

    public CalcCommand(Main receiver, int number) {
        this.receiver = receiver;
        this.number = number;
    }

    @Override
    public void execute() {
        // Створюємо результат і додаємо в список
        result = new CalculationResult(number, Integer.toBinaryString(number), 
                                     Integer.toOctalString(number), 
                                     Integer.toHexString(number).toUpperCase());
        receiver.results.add(result);
        System.out.println("Команда виконана: додано число " + number);
    }

    @Override
    public void undo() {
        // Видаляємо саме той результат, який додали цією командою
        if (result != null) {
            receiver.results.remove(result);
            System.out.println("Скасовано: число " + number + " видалено.");
        }
    }
}