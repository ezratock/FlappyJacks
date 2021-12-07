import java.awt.*;

public class Pillar extends GameComponent {
    private RectangleComponent lower = new RectangleComponent(0, 0, 0, 0, Color.pink);
    private RectangleComponent upper = new RectangleComponent(0, 0, 0, 0, Color.pink);
    private int movePixels;
    private int WIDTH;
    private Color COLOR = Color.PINK;

    public void setMovePixels(int movePixels) {
        this.movePixels = movePixels;
    }

    public Pillar(boolean isSecond, int movePixels) {
        this.WIDTH = (int) WIDTH;
        this.movePixels = movePixels;
        initializePillar(isSecond);

    }

    private RectangleComponent initializeLower(double width, int height, int gap) {
        return new RectangleComponent(GameFrame.WIDTH, gap + (int) (GameFrame.HEIGHT * (3f / 14f)), GameFrame.WIDTH / 7, GameFrame.HEIGHT - (gap + GameFrame.HEIGHT / 7), COLOR); //creates bottom rectangle
    }

    private RectangleComponent initializeUpper(double width, int height, int gap) {
        return new RectangleComponent(GameFrame.WIDTH, 0, GameFrame.WIDTH / 7, gap, COLOR); //creates top rectangle
    }

    @Override
    public void paintComponent(Graphics g) {
        upper.paintComponent(g);
        lower.paintComponent(g);

    }

    @Override
    public void update() {
        //moveleft
        lower.setX((lower.getX() - movePixels));
        upper.setX((upper.getX() - movePixels));
    }

    public boolean isAtEnd() {
        return lower.getX() + lower.getWidth() <= 0;
    }

    public boolean passedBird() {
        return lower.getX() <= Bird.X_POS - lower.getWidth() && lower.getX() > Bird.X_POS - lower.getWidth() - movePixels;
    }

    public void reset() {
        int gap = (int) ((Math.random() * GameFrame.HEIGHT) * (7f / 14f) + ((1f / 7f) * (double) GameFrame.HEIGHT));
        upper = initializeUpper(GameFrame.WIDTH, GameFrame.HEIGHT, gap);
        lower = initializeLower(GameFrame.WIDTH, GameFrame.HEIGHT, gap);
    }

    public void initializePillar(boolean isSecond) {
        int gap = (int) ((Math.random() * GameFrame.HEIGHT) * (7f / 14f) + ((1f / 7f) * (double) GameFrame.HEIGHT));
        if (isSecond) {
            upper.setX((int) (GameFrame.WIDTH * (1.5 + 1f / 14f))); //1/14 is half a pillar width
            lower.setX((int) (GameFrame.WIDTH * (1.5 + 1f / 14f)));
        } else {
            upper = initializeUpper(WIDTH, HEIGHT, gap);
            lower = initializeLower(WIDTH, HEIGHT, gap);
        }
    }


    public void checkCollision(int x, int y) {

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
}
