import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class GamePanel extends JPanel {
    Pillars pillars;
    Bird bird = new Bird();
    UI userInterface = new UI();
    private Image background = null;
    MovingGroup ground;
    public static boolean gameOver = false;
    public static boolean reset = false;

    GamePanel() {
        this.setBackground(new Color(222,216,149));
        this.addKeyListener(bird);
        pillars = new Pillars();
        this.add(pillars);
        try {
            this.background = ImageIO.read(new File("images/background.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        int groundY = GameFrame.HEIGHT - 100;
        double groundScale = 0.25; //from 0.2 to 0.4
        double groundRatio = 2.4555; //depending on image
        ground = new MovingGroup(new MovingObj("images/ground.png", 0, groundY, groundScale),
                new MovingObj("images/ground.png", (int) (groundScale * groundRatio * GameFrame.WIDTH), groundY, groundScale),
                new MovingObj("images/ground.png", (int) (groundScale * groundRatio * 2 * GameFrame.WIDTH), groundY, groundScale),
                new MovingObj("images/ground.png", (int) (groundScale * groundRatio * 3 * GameFrame.WIDTH), groundY, groundScale));
    }


    public void paint(Graphics g) {
        super.paint(g);
        g.drawImage(background, 0, 0, this);
        ground.paintComponent(g);
        pillars.paintComponent(g);
        bird.paintComponent(g);
        userInterface.paintComponent(g);
    }

    public void update() {
        repaint();
        GameComponent obj = checkCollisions(pillars.getRects());

        if (obj != null || bird.getIsAtBottom()) {
            if (!gameOver) {
                bird.setVelocity(0);
            }
            bird.setIsDead();
            Game.moveSpeed = 0;
            gameOver = true;

        }
        ground.update();
        pillars.update();
        bird.update();
        userInterface.update();
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
