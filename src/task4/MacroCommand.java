import java.util.ArrayList;
import java.util.List;

public class MacroCommand implements Command {
    private List<Command> commands = new ArrayList<>();

    public void add(Command cmd) {
        commands.add(cmd);
    }

    @Override
    public void execute() {
        System.out.println("Виконання макрокоманди...");
        for (Command cmd : commands) cmd.execute();
    }

    @Override
    public void undo() {
        System.out.println("Скасування макрокоманди...");
        // Скасовуємо у зворотному порядку (як у стеку)
        for (int i = commands.size() - 1; i >= 0; i--) {
            commands.get(i).undo();
        }
    }
}