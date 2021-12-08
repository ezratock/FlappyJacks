import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Bird extends GameComponent implements KeyListener {
    private double velocity;
    private final double ACCEL_DEFAULT = .4;
    private double accelValue = ACCEL_DEFAULT;
    private final double JUMPVAL = -8;
    private int yPos;
    private static final int HITBOX_DIMENSION = 30;
    public static final int X_POS = 100;
    private boolean isDead = false;
    private final int GUI_OFFSET_FUCKED_UP = 0;
    private final int MAX_VEL = 13;
    private final double scale = 0.15;
    private Image[] images = new Image[]{null, null, null};
    private BufferedImage[] bufferedImages = new BufferedImage[]{null, null, null};
    private boolean isFlap = false;

    public Bird() {
        yPos = GameFrame.HEIGHT / 2 - HITBOX_DIMENSION / 2;
        String[] filePaths = new String[]{"../images/pancake.png", "../images/pancakeFlap.png", "../images/pancakeDeath.png"};
        if (Game.currentDirectory.equals("Project3")) {
            filePaths = new String[]{"images/pancake.png", "images/pancakeFlap.png", "images/pancakeDeath.png"};
        }

        for (int x = 0; x < 3; x++) {
            try {
                bufferedImages[x] = ImageIO.read(new File(filePaths[x]));
                images[x] = bufferedImages[x].getScaledInstance((int) (bufferedImages[x].getWidth() * scale), (int) (bufferedImages[x].getHeight() * scale), Image.SCALE_SMOOTH);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void paintComponent(Graphics g) {
        g.drawImage(isDead ? images[2] : isFlap ? images[1] : images[0], X_POS - 55 , yPos - 42, null);
//        g.fillRect(X_POS, yPos, HITBOX_DIMENSION, HITBOX_DIMENSION);
    }

    public void applyPhysAlive() {
        if (deadBool()) {
            isDead = true;
        } else {
            yPos += velocity;
            if (velocity > MAX_VEL) {
                velocity = MAX_VEL;
            }
            velocity += accelValue;
        }
    }

    public void applyPhysDead() {
        if (deadBool()) {
            velocity = 0;
            accelValue = 0;
            yPos = GameFrame.HEIGHT - HITBOX_DIMENSION - GUI_OFFSET_FUCKED_UP - GamePanel.GROUND_HEIGHT;
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
        yPos = GameFrame.HEIGHT / 2 - HITBOX_DIMENSION / 2;
    }

    @Override
    public void update() {
        if (deadBool() || yPos<0) {
            isDead = true;
        }
        if (isDead) {
            applyPhysDead();
        } else {
            applyPhysAlive();
        }
    }

    public boolean getIsAtBottom() {
        return isDead;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }
    @Override
    public void keyPressed(KeyEvent e) {
        if (!isDead) {
            velocity = JUMPVAL;
            isFlap = true;
        }
        else {
            GamePanel.reset = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        isFlap = false;
    }

    @Override
    public int[] getProperties() {
        return new int[]{X_POS, yPos, HITBOX_DIMENSION, HITBOX_DIMENSION};
    }

    public int getyPos() {
        return yPos;
    }

    public void setVelocity(int v){
        velocity = v;
    }

    private boolean deadBool() {
        return yPos > GameFrame.HEIGHT - GUI_OFFSET_FUCKED_UP - HITBOX_DIMENSION - GamePanel.GROUND_HEIGHT;
    }
}
