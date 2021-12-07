import java.awt.*;
import javax.swing.*;

public class GameFrame extends JFrame {
    public final static int HEIGHT = 460;
    public final static int WIDTH = 510;

    GamePanel panel;

    GameFrame(){
        panel = new GamePanel();
        panel.setFocusable(true);
        this.add(panel);
        this.setSize(new Dimension(WIDTH, HEIGHT));
        this.setTitle("SUPER ENTICING TITLE");
        this.setResizable(false);
        this.setBackground(Color.blue);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }

    public void update() {
        panel.update();
    }
}
