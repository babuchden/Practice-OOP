package task7;
import java.util.List;
import task4.Displayable;

public class ConsoleObserver implements Observer {
    @Override
    public void update(List<Displayable> data) {
        System.out.println("\n[Console Observer] Дані оновлено! Кількість елементів: " + data.size());
    }
}