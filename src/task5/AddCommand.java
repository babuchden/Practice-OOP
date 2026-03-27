package task5;
import java.util.List;
import task4.Displayable;
import task4.ResultFactory;

public class AddCommand implements Command {
    private List<Displayable> list;
    private ResultFactory factory;
    private int number;
    private Displayable result;

    public AddCommand(List<Displayable> list, ResultFactory factory, int number) {
        this.list = list;
        this.factory = factory;
        this.number = number;
    }

    @Override
    public void execute() {
        result = factory.createResult(number);
        list.add(result);
    }

    @Override
    public void undo() {
        list.remove(result);
    }
}