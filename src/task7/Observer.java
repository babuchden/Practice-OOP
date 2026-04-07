package task7;
import java.util.List;
import task4.Displayable;

public interface Observer {
    void update(List<Displayable> data);
}