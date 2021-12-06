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

    public Pillar(double WIDTH, int HEIGHT, boolean isSecond, int movePixels) {
        this.WIDTH = (int)WIDTH;
        this.movePixels = movePixels;
        int gap = (int) ((Math.random() * HEIGHT) / 5f + (0.2f) * HEIGHT);
        upper = initializeUpper(WIDTH, HEIGHT, gap);
        lower = initializeLower(WIDTH, HEIGHT, gap);
        if (isSecond) {
            upper.setX((int) (GameFrame.FRAME_WIDTH * (1.5 + 1f/14f))); //1/14 is half a pillar width
            lower.setX((int) (GameFrame.FRAME_WIDTH * (1.5 + 1f/14f)));
        }

    }

    private RectangleComponent initializeLower(double width, int height, int gap) {
        return new RectangleComponent(GameFrame.FRAME_WIDTH, gap + GameFrame.FRAME_HEIGHT / 7, GameFrame.FRAME_WIDTH / 7, GameFrame.FRAME_HEIGHT - (gap + GameFrame.FRAME_HEIGHT / 7), COLOR); //creates bottom rectangle
    }

    private RectangleComponent initializeUpper(double width, int height, int gap) {
        return new RectangleComponent(GameFrame.FRAME_WIDTH, 0, GameFrame.FRAME_WIDTH / 7, gap, COLOR); //creates top rectangle
    }

    @Override
    public void paintComponent(Graphics g) {
        upper.paintComponent(g);
        lower.paintComponent(g);

    }

    @Override
    public void update() {
        //moveleft
        lower.setX((lower.getX()-movePixels));
        upper.setX((upper.getX()-movePixels));
    }

    public boolean isAtEnd () {
        return lower.getX() + lower.getWidth() <= 0;
    }

    public boolean passedBird () {
        return lower.getX() <= Bird.X_POS - lower.getWidth() && lower.getX() > Bird.X_POS - lower.getWidth() - movePixels;
    }

    public void reset() {
        int gap = (int) ((Math.random() * GameFrame.FRAME_HEIGHT)*(4f/7f) + ((1f/7f) * (double)GameFrame.FRAME_HEIGHT));
        upper = initializeUpper(GameFrame.FRAME_WIDTH, GameFrame.FRAME_HEIGHT, gap);
        lower = initializeLower(GameFrame.FRAME_WIDTH, GameFrame.FRAME_HEIGHT, gap);
    }


    public void checkCollision(int x, int y) {

    }


    public RectangleComponent getLower() {
        return lower;
    }

    public RectangleComponent getUpper() {
        return upper;
    }
}
