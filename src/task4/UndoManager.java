import java.util.Stack;

public class UndoManager {
    private static UndoManager instance;
    private Stack<Command> history = new Stack<>();

    private UndoManager() {}

    public static UndoManager getInstance() {
        if (instance == null) {
            instance = new UndoManager();
        }
        return instance;
    }

    public void execute(Command cmd) {
        cmd.execute();
        history.push(cmd);
    }

    public void undo() {
        if (!history.isEmpty()) {
            history.pop().undo();
        } else {
            System.out.println("Історія порожня. Нічого скасовувати.");
        }
    }
}