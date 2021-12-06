import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;

public class TestPainting extends JComponent {

    @Override
    public void paintComponent(Graphics g) {
        this.setSize(new Dimension(460,510));
        Graphics2D graphics = (Graphics2D)g;
        Line2D.Double line = new Line2D.Double(20,20,200,200);
        System.out.println("line should be drawn");
        graphics.fill(line);
        graphics.draw(line);
        //g.drawLine(02,20,200,200);
        //graphics.drawLine(20,20,200,200);
    }

}
