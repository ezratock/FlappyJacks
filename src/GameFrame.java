import java.awt.*;
import javax.swing.*;

public class GameFrame extends JFrame {
    private final int HEIGHT = 460;
    private final int WIDTH = 510;

    GamePanel panel;

    GameFrame(){
        panel = new GamePanel();
        this.add(panel);
        this.setSize(new Dimension(WIDTH, HEIGHT));
//        this.setTitle("SUPER ENTICING TITLE");
//        this.setResizable(false);
//        this.setBackground(Color.blue);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
//        this.setLocationRelativeTo(null);
    }

//    public void update() {
//        panel.update();
//    }
}
