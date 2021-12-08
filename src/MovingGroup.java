import java.awt.*;

public class MovingGroup extends GameComponent{
    private MovingObj[] objects;

    public MovingGroup(MovingObj... objects) {
        this.objects = objects;
    }

    @Override
    public void paintComponent(Graphics g) {
        for (MovingObj obj : objects) {
            obj.paintComponent(g);
        }
    }

    @Override
    public void update() {
        for (MovingObj obj : objects) {
            obj.update();
        }
    }

    @Override
    public int[] getProperties() {
        return new int[4];
    }
}
