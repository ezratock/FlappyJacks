import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class MovingObj extends GameComponent {
    private BufferedImage bufferedImage;
    private Image image;
    private int x;
    private int y;
    private double scale;

    public MovingObj(String imagePath, int x, int y, double scale){
        this.x = x;
        this.y = y;
        this.scale = scale;
        this.image = null;
        try {
            this.bufferedImage = ImageIO.read(new File(imagePath));
            this.image = bufferedImage.getScaledInstance((int) (bufferedImage.getWidth() * scale), (int) (bufferedImage.getHeight() * scale), Image.SCALE_SMOOTH);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        g.drawImage(image, x, y, null);
    }

    @Override
    public void update() {
        x -= Game.moveSpeed;
    }

    @Override
    public int[] getProperties() {
        return new int[4];
    }

    public boolean isOffScreen() {
        return x + bufferedImage.getWidth() * scale < 0;
    }

    public void recycle(double width) {
        if (x < -width) {
            x += width * 4;
        }
    }
}
