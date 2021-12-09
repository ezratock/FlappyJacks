package src;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class RectangleComponent extends GameComponent {

    @Override
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    @Override
    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    @Override
    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    private int x;
    private int y;
    private int width;
    private int height;
    private Color color;
    private boolean isTop;
    private Rectangle rectangle;
    private Image image;
    private final double scale = 0.69;
    private final int imageHeight = (int) (690 * scale);
    private final int imageWhiteSpace = 5;

    public RectangleComponent(int x, int y, int width, int height, boolean isTop, boolean isReal) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = Color.PINK;
        this.isTop = isTop;
        this.rectangle = new Rectangle(x, y, width, height);
        if (isReal) {
            String tForkImagePath;
            String bForkImagePath;
            if (Game.currentDirectory.equals("Project3")) {
                bForkImagePath = "images/bottomFork.png";
                tForkImagePath = "images/topFork.png";
            } else {
                bForkImagePath = "../images/bottomFork.png";
                tForkImagePath = "../images/topFork.png";
            }
            String filePath = isTop ? tForkImagePath : bForkImagePath;
            image = null;
            BufferedImage bufferedImage;
            try {
                bufferedImage = ImageIO.read(new File(filePath));
                image = bufferedImage.getScaledInstance((int) (bufferedImage.getWidth() * scale), (int) (bufferedImage.getHeight() * scale), Image.SCALE_SMOOTH);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    @Override
    public void paintComponent(Graphics g) {
//        g.setColor(this.color);
//        g.fillRect(x, y, width, height);
        g.drawImage(image, x - (int) (imageWhiteSpace*1.75), (isTop ? y + height - imageHeight + imageWhiteSpace : y - imageWhiteSpace), null);
    }

    @Override
    public void update() {
    }

    @Override
    public int[] getProperties() {
        return new int[]{x, y, width, height};
    }
}

