import javax.swing.JPanel;
import java.awt.*;
import java.lang.Runnable;

public class GamePanel extends JPanel implements Runnable{

    static final int WIDTH = 480;
    static final int HEIGHT = 360;
    static final Dimension frameDimension = new Dimension(WIDTH, HEIGHT);

    private static Thread thread;
    private static final double FPS = 60.0;
    Bird bird;

    public GamePanel() {
        this.setPreferredSize(frameDimension);
        thread.start();
    }

    public void run() {
        long previousTime = System.nanoTime();
        while (true) {
            long currentTime = System.nanoTime();
            long delta = (currentTime - previousTime);
            previousTime = currentTime;

            try {
                thread.sleep((long)(1000000000.0/FPS - delta));
            } catch (Exception e) {
                e.printStackTrace();
            }

            System.out.println("One Frame passed!");
            //run drawing methods
        }

    }

    public void draw(Graphics g) {

    }

    public void move() {

    }
}
