import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;

public class TestPainting extends JComponent {

    @Override
    public void paintComponent(Graphics g) {
        Graphics2D graphics = (Graphics2D)g;
        graphics.setColor(Color.blue);
        Line2D.Double line = new Line2D.Double(20,20,20,20);
        graphics.fill(line);
        graphics.draw(line);
    }
}
