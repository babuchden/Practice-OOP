package task7;
import java.util.*;
import task4.Displayable;

@MyAnnotation(info = "Data Storage for Observer Pattern")
public class DataModel implements Observable {
    private List<Displayable> data = new ArrayList<>();
    private List<Observer> observers = new ArrayList<>();

    public void addData(Displayable item) {
        data.add(item);
        notifyObservers();
    }

    public List<Displayable> getData() { return data; }

    @Override
    public void addObserver(Observer o) { observers.add(o); }

    @Override
    public void notifyObservers() {
        for (Observer o : observers) o.update(data);
    }

    public void showReflectionInfo() {
        Class<?> clazz = this.getClass();
        System.out.println("[Reflection] Аналіз класу: " + clazz.getName());
        if (clazz.isAnnotationPresent(MyAnnotation.class)) {
            MyAnnotation ann = clazz.getAnnotation(MyAnnotation.class);
            System.out.println("[Reflection] Анотація знайдена: " + ann.info());
        }
    }
}