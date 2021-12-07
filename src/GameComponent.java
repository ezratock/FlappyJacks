import javax.swing.*;

public abstract class GameComponent extends JComponent {

    public abstract void update();

    public abstract int[] getProperties();
}
