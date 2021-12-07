import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GamePanel extends JPanel {
    Pillars pillars;
    Bird bird = new Bird();
    UI userInterface = new UI();
    public static boolean gameOver = false;
    public static boolean reset = false;
    //public static boolean gamePlaying = true;

    JButton restart = new JButton("Restart");


    GamePanel() {
        this.setBackground(Color.CYAN);
        this.addKeyListener(bird);
        pillars = new Pillars();
        this.add(pillars);
//        this.add(restart);
//        restart.setVisible(true);
//        restart.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent but) {
//                System.out.println("restart");
//                reset = true;
//            }
//        });
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

        if (obj!=null || bird.getIsAtBottom()) {
//            System.out.println("Collided with pillar");
            bird.setIsDead();
            pillars.stopMoving();
            gameOver = true;

        }
        pillars.update();
        bird.update();
        userInterface.update();
    }

    public void reset(){
        pillars.resetPillars();
        pillars.startMoving();
        bird.reset();
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
