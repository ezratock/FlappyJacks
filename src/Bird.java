import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Bird extends GameComponent implements KeyListener {
    private double velocity;
    private final double ACCEL_DEFAULT = .4;
    private double accelValue = ACCEL_DEFAULT;
    private final double JUMPVAL = -8;
    private int yPos;
    private static final int BIRD_DIMENSION = 20;
    public static final int X_POS = 50;
    private boolean isDead = false;
    private final int GUI_OFFSET_FUCKED_UP = 37;
    private final int MAX_VEL = 13;

    public Bird() {
        yPos = GameFrame.HEIGHT / 2 - BIRD_DIMENSION / 2;
    }

    public void paintComponent(Graphics g) {
        g.setColor(Color.ORANGE);
        g.fillRect(X_POS, yPos, BIRD_DIMENSION, BIRD_DIMENSION);

    }

    public void applyPhysAlive() {
        if (yPos > GameFrame.HEIGHT - BIRD_DIMENSION) {
            isDead = true;
        } else {
            yPos += velocity;
            System.out.println("Velocity: " + velocity);
            if (velocity > MAX_VEL) {
                velocity = MAX_VEL;
            }
            velocity += accelValue;
        }
    }

    public void applePhysDead() {
        if (yPos >= GameFrame.HEIGHT - BIRD_DIMENSION - GUI_OFFSET_FUCKED_UP) {
            velocity = 0;
            accelValue = 0;
            yPos = GameFrame.HEIGHT - BIRD_DIMENSION - GUI_OFFSET_FUCKED_UP;
        } else {
            applyPhysAlive();
        }
    }

    public void setIsDead() {
        isDead = true;
    }

    public void reset() {
        isDead = false;
        accelValue = ACCEL_DEFAULT;
        yPos = GameFrame.HEIGHT / 2 - BIRD_DIMENSION / 2;
    }

    @Override
    public void update() {
//        applyPhysAlive();
        if (getyPos() > GameFrame.HEIGHT - GUI_OFFSET_FUCKED_UP - BIRD_DIMENSION) {
            isDead = true;
        }
        if (isDead) {
            applePhysDead();
//            System.out.println("You are Dead");
        } else
            applyPhysAlive();
    }

    public boolean getIsAtBottom() {
        return isDead;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (!isDead)
            velocity = JUMPVAL;
        else {
            GamePanel.reset = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public int[] getProperties() {
        return new int[]{X_POS, yPos, BIRD_DIMENSION, BIRD_DIMENSION};
    }

    public int getyPos() {
        return yPos;
    }
}
