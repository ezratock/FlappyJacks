import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Bird extends GameComponent implements KeyListener{
    private double velocity;
    private final double ACCEL = 0.5;
    private final double JUMPVAL = -8;
    private int yPos;
    private final int BIRD_DIMENSION = 20;
    public static final int X_POS = 50;

    public Bird(){
        this.yPos = GameFrame.FRAME_HEIGHT / 2 - BIRD_DIMENSION / 2;
    }

    public void paintComponent(Graphics g){
        g.setColor(Color.ORANGE);
        g.fillRect(X_POS, yPos, BIRD_DIMENSION, BIRD_DIMENSION);

    }



    public void applyPhys(){
        yPos += velocity;
        velocity += ACCEL;

    }
    @Override
    public void update() {
        applyPhys();
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        velocity=JUMPVAL;
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
