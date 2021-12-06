import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {
    Pillars pillars;
    Bird bird = new Bird();
    UI userInterface = new UI();

    GamePanel (int FRAME_HEIGHT, int FRAME_WIDTH) {
        this.setBackground(Color.CYAN);
        this.addKeyListener(bird);
        pillars = new Pillars(FRAME_HEIGHT, FRAME_WIDTH);
        this.add(pillars);
        System.out.println("made it to construcotr of GameFrame");
    }


    public void paint (Graphics g){
        super.paint(g);
        pillars.paintComponent(g);
        bird.paintComponent(g);
        userInterface.paintComponent(g);


    }

    public void update() {
        repaint();
        pillars.update();
        bird.update();
        userInterface.update();
    }
}
