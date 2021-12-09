package src;
import java.awt.*;

public class Pillar extends GameComponent {
    private RectangleComponent lower = new RectangleComponent(0, 0, 0, 0, false, false);
    private RectangleComponent upper = new RectangleComponent(0, 0, 0, 0, true, false);
    private Color COLOR = Color.PINK;

    public Pillar(boolean isSecond) {
        initializePillar(isSecond);

    }

    private RectangleComponent initializeLower(int gap) {
        return new RectangleComponent(GameFrame.WIDTH, gap + (int) (GameFrame.HEIGHT * (3f / 14f)), GameFrame.WIDTH / 7, GameFrame.HEIGHT - (gap + GameFrame.HEIGHT / 7), false, true); //creates bottom rectangle
    }

    private RectangleComponent initializeUpper(int gap) {
        return new RectangleComponent(GameFrame.WIDTH, 0, GameFrame.WIDTH / 7, gap, true, true); //creates top rectangle
    }

    @Override
    public void paintComponent(Graphics g) {
        upper.paintComponent(g);
        lower.paintComponent(g);

    }

    @Override
    public void update() {
        //moveleft
        lower.setX((lower.getX() - Game.moveSpeed));
        upper.setX((upper.getX() - Game.moveSpeed));
    }

    public boolean isAtEnd() {
        return lower.getX() + lower.getWidth() <= 0;
    }

    public boolean passedBird() {
        return lower.getX() <= Bird.X_POS - lower.getWidth() && lower.getX() > Bird.X_POS - lower.getWidth() - Game.moveSpeed;
    }

    public void reset() {
        int gap = initializeGap();
        upper = initializeUpper(gap);
        lower = initializeLower(gap);
    }

    public void initializePillar(boolean isSecond) {
        int gap = initializeGap();
        if (isSecond) {
            upper = initializeUpper(gap);
            lower = initializeLower(gap);
            upper.setX((int) (GameFrame.WIDTH * (1.5 + 1f / 14f))); //1/14 is half a pillar width
            lower.setX((int) (GameFrame.WIDTH * (1.5 + 1f / 14f)));
        } else {
            upper = initializeUpper(gap);
            lower = initializeLower(gap);
        }
    }


    public RectangleComponent getLower() {
        return lower;
    }

    public RectangleComponent getUpper() {
        return upper;
    }

    @Override
    public int[] getProperties() {
        return new int[]{-1, -1, -1, -1};
    }

    private int initializeGap() {
        return (int) ((Math.random() * GameFrame.HEIGHT) * (3f / 7f) + ((1f / 7f) * (double) GameFrame.HEIGHT));
    }
}
