import javax.swing.*;
import java.awt.*;

public class Pillar extends GameComponent{
    private RectangleComponent lower;
    private RectangleComponent upper;
    private int movePixels;
    private int WIDTH;
    private Color COLOR = Color.PINK;


    public void setMovePixels(int movePixels) {
        this.movePixels = movePixels;
    }

    public Pillar(double WIDTH, int HEIGHT, boolean isReal, int movePixels) {
        this.WIDTH = (int)WIDTH;
        this.movePixels = movePixels;
        if (isReal) {
            int gap = (int) ((Math.random() * HEIGHT) / 5f + (0.2f) * HEIGHT);
            upper = new RectangleComponent((int)WIDTH, 0, (int)WIDTH / 7, gap, COLOR); //creates top rectangle
            lower = new RectangleComponent((int)WIDTH, gap + HEIGHT / 7, (int)WIDTH / 7, HEIGHT - (gap + HEIGHT / 7), COLOR); //creates bottom rectangle
        } else {
            upper = new RectangleComponent((int)WIDTH, HEIGHT,0,0, COLOR);
            lower = new RectangleComponent((int)WIDTH,HEIGHT,0,0, COLOR);
        }

    }

    @Override
    public void paintComponent(Graphics g) {
        upper.paintComponent(g);
        lower.paintComponent(g);

    }

    @Override
    public void update() {
        //moveleft
        lower.setX((int)(lower.getX()-movePixels));
        upper.setX((int)(upper.getX()-movePixels));
        lower.update();
        upper.update();
    }

    public boolean isAtEnd () {
        if(lower.getX() + lower.getWidth() <= 0) {
            return true;
        } else {
            return false;
        }
    }

    public void checkCollision(int x, int y) {

    }

    public void reset() {
        upper.setX(WIDTH);
        lower.setX(WIDTH);
    }

//    public void addToFrame(JFrame frame) {
//        frame.add(upper);
//        frame.add(lower);
//    }

    public RectangleComponent getLower() {
        return lower;
    }

    public RectangleComponent getUpper() {
        return upper;
    }
}
