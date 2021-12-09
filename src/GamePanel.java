package src;
import java.awt.*;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

public class GamePanel extends JPanel {
    Pillars pillars;
    Bird bird = new Bird();
    UI userInterface = new UI();
    private Image background = null;
    MovingGroup ground;
    public static boolean gameOver = false;
    public static boolean reset = false;
    private final double GROUND_SCALE = 0.25; //from 0.2 to 0.4
    private final double GROUND_IMG_WIDTH = 1475; //Image Width
    public static final int GROUND_HEIGHT = 100;

    GamePanel() {
        this.setBackground(new Color(222,216,149));
        this.addKeyListener(bird);
        pillars = new Pillars();
        this.add(pillars);
        try {
            this.background = ImageIO.read(new File(Game.currentDirectory.equals("Project3") ? "images/background.png" : "../images/background.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        int groundY = GameFrame.HEIGHT - GROUND_HEIGHT;
        if (Game.currentDirectory.equals("Project3")) {
            ground = new MovingGroup(new MovingObj("images/ground.png", 0, groundY, GROUND_SCALE),
                    new MovingObj("images/ground.png", (int) (GROUND_SCALE * GROUND_IMG_WIDTH), groundY, GROUND_SCALE),
                    new MovingObj("images/ground.png", (int) (GROUND_SCALE * GROUND_IMG_WIDTH * 2), groundY, GROUND_SCALE),
                    new MovingObj("images/ground.png", (int) (GROUND_SCALE * GROUND_IMG_WIDTH * 3), groundY, GROUND_SCALE));
        } else  {
            ground = new MovingGroup(new MovingObj("../images/ground.png", 0, groundY, GROUND_SCALE),
                    new MovingObj("../images/ground.png", (int) (GROUND_SCALE * GROUND_IMG_WIDTH), groundY, GROUND_SCALE),
                    new MovingObj("../images/ground.png", (int) (GROUND_SCALE * GROUND_IMG_WIDTH * 2), groundY, GROUND_SCALE),
                    new MovingObj("../images/ground.png", (int) (GROUND_SCALE * GROUND_IMG_WIDTH * 3), groundY, GROUND_SCALE));
        }
    }


    public void paint(Graphics g) {
        super.paint(g);
        g.drawImage(background, 0, 0, this);
        pillars.paintComponent(g);
        ground.paintComponent(g);
        bird.paintComponent(g);
        userInterface.paintComponent(g);
    }

    public void update(boolean birdDead) {
        repaint();
        if(birdDead) {
            bird.update();
        } else {
            GameComponent obj = checkCollisions(pillars.getRects());

            if (obj != null || bird.getIsAtBottom()) {
                if (!gameOver) {
                    bird.setVelocity(0);
                }
                bird.setIsDead();
                Game.moveSpeed = 0;
                gameOver = true;

            }
            ground.recycle(GROUND_IMG_WIDTH * GROUND_SCALE);
            ground.update();
            pillars.update();
            bird.update();
            userInterface.update();
        }

    }

    public void reset() {
        pillars.resetPillars();
        Game.moveSpeed = Game.ORIGINAL_MOVE_SPEED;
        bird.reset();
    }


    public GameComponent checkCollisions(GameComponent[] objects) {
        int[] bp = bird.getProperties();
        for (GameComponent object : objects) {
            int[] op = object.getProperties();
            if ((op[0] - bp[2] <= bp[0] && bp[0] <= op[0] + op[2]) && (op[1] - bp[3] <= bp[1] && bp[1] <= op[1] + op[3])) { //if x ranges overlap and y ranges overlap...
                return object;
            }
        }
        return null;
    }

}

