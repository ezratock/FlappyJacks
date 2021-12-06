import java.awt.*;

public class Pillar {
    private Rectangle lower;
    private Rectangle upper;

    public Pillar(int HEIGHT, int WIDTH, boolean isReal) {
        if (isReal) {
            int gap = (int) ((Math.random() * HEIGHT) / 5f + (0.2f) * HEIGHT);
            upper = new Rectangle(WIDTH, 0, WIDTH / 7, gap); //creates top rectangle
            lower = new Rectangle(WIDTH, gap + HEIGHT / 7, WIDTH / 7, HEIGHT - (gap + HEIGHT / 7)); //creates bottom rectangle
        } else {
            upper = new Rectangle(WIDTH, HEIGHT,0,0);
            lower = new Rectangle(WIDTH,HEIGHT,0,0);
        }

    }

    public void updatePillar(double movePixels) {
        //moveleft
        lower.x -= movePixels;
        upper.x -= movePixels;
    }

    public void checkCollision(int x, int y) {

    }
}
