import javax.swing.*;
import java.awt.*;

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
    private Rectangle rectangle;

    public RectangleComponent(int x, int y, int width, int height, Color color) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = color;
        rectangle = new Rectangle(x, y, width, height);

    }

    @Override
    public void paintComponent(Graphics g) {
        g.setColor(this.color);
        g.fillRect(x, y, width, height);
    }

    @Override
    public void update(){}

    @Override
    public int[] getProperties(){
        return new int[]{x, y, width, height};
    }
}
