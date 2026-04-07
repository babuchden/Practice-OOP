package task7;
import javax.swing.*;
import java.awt.*;
import java.util.List;
import task4.Displayable;

public class GraphView extends JFrame implements Observer {
    private List<Displayable> currentData;

    public GraphView() {
        setTitle("Графічний монітор (Task 7)");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public void update(List<Displayable> data) {
        this.currentData = data;
        repaint(); // Автоматичне перемальовування
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        if (currentData == null || currentData.isEmpty()) return;
        
        g.setColor(Color.RED);
        int x = 50;
        for (int i = 0; i < currentData.size(); i++) {
            // Малюємо стовпчик (фіксована висота для тесту)
            g.fillRect(x, 300 - 100, 30, 100); 
            g.setColor(Color.BLACK);
            g.drawString("#" + (i+1), x, 320);
            g.setColor(Color.RED);
            x += 50;
        }
    }
}