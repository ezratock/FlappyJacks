import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {
    Pillars pillars;
    Bird bird = new Bird();
    UI userInterface = new UI();

    GamePanel() {
        this.setBackground(Color.CYAN);
        this.addKeyListener(bird);
        pillars = new Pillars();
        this.add(pillars);
    }


    public void paint (Graphics g){
        super.paint(g);
        pillars.paintComponent(g);
        bird.paintComponent(g);
        userInterface.paintComponent(g);
    }

    public void update() {
        repaint();
        GameComponent obj = checkCollisions(pillars.getRects());
        if (obj!=null) {
            System.out.println("Collided with pillar");
        }

        pillars.update();
        bird.update();
        userInterface.update();
    }

    public GameComponent checkCollisions(GameComponent[] objects) {
        int[] bp = bird.getProperties();
        for (GameComponent object: objects) {
            int[] op = object.getProperties();
            if ((op[0]-bp[2] <= bp[0] && bp[0] <= op[0]+op[2]) && (op[1]-bp[3] <= bp[1] && bp[1] <= op[1]+op[3])){ //if x ranges overlap and y ranges overlap...
                return object;
            }
        }
        return null;
    }
}
