import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Game {
    public static void main(String[] args) {
        GameFrame gameFrame = new GameFrame();
        final int DELAY = 10;
        Timer timer = new Timer(DELAY, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameFrame.update();
            }
        });
        timer.start();
    }
}
