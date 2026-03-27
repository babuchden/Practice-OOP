package task5;
import java.util.Stack;

public class CommandManager {
    private static CommandManager instance;
    private Stack<Command> history = new Stack<>();

    private CommandManager() {} // Приватний конструктор

    public static CommandManager getInstance() {
        if (instance == null) instance = new CommandManager();
        return instance;
    }

    public void execute(Command cmd) {
        cmd.execute();
        history.push(cmd);
    }

    public void undo() {
        if (!history.isEmpty()) history.pop().undo();
        else System.out.println("Нічого скасовувати!");
    }
}