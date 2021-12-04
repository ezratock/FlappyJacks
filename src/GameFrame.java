import java.awt.*;
import javax.swing.*;

public class GameFrame extends JFrame {

    GameFrame(){
        System.out.println("made it to construcotr of GameFrame");
        GamePanel panel = new GamePanel();
        this.add(panel);
        this.setTitle("SUPER ENTICING TITLE");
        this.setResizable(false);
        this.setBackground(Color.blue);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }
}
