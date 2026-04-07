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

    // Ми просто додаємо команду в історію, 
    // бо її виконання (execute) тепер робить фоновий потік
    public void addHistory(Command cmd) {
        history.push(cmd);
    }

    public void undo() {
        if (!history.isEmpty()) {
            Command cmd = history.pop();
            cmd.undo();
        } else {
            System.out.println("Історія порожня.");
        }
    }
}