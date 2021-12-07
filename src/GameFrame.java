import java.awt.*;
import javax.swing.*;

public class GameFrame extends JFrame {
    public final static int HEIGHT = 600;
    public final static int WIDTH = 600;

    GamePanel panel;

    GameFrame() {
        panel = new GamePanel();
        panel.setFocusable(true);
        this.add(panel);
        this.setSize(new Dimension(WIDTH, HEIGHT));
        this.setTitle("Flappy Jack");
        this.setResizable(false);
        this.setBackground(Color.blue);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }

    public void reset() {
        panel.reset();
    }

    public void update() {
        panel.update();
    }
}
