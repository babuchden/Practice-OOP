package task5;
import java.util.*;

public class MacroCommand implements Command {
    private List<Command> commands = new ArrayList<>();

    public void add(Command cmd) { commands.add(cmd); }

    @Override
    public void execute() { commands.forEach(Command::execute); }

    @Override
    public void undo() {
        for (int i = commands.size() - 1; i >= 0; i--) {
            commands.get(i).undo();
        }
    }
}