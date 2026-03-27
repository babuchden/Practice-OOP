package task5;

/** Інтерфейс для команд з підтримкою скасування */
public interface Command {
    void execute();
    void undo();
}