import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Game {
    private static GameFrame gameFrame = new GameFrame();

    public static void main(String[] args) {

        final int DELAY = 10;
        Timer timer = new Timer(DELAY, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameFrame.update();
            }
        });
        timer.start();

        while (true) {
            if (GamePanel.gameOver) {
                timer.stop();
                if (GamePanel.reset) {
                    resetGame();
                    timer.restart();
                }
            }
            if (GamePanel.reset) {
                resetGame();
                timer.restart();
            }
        }

    }

    public static void resetGame() {
        UI.resetScore();
        gameFrame.reset();
        GamePanel.reset = false;
        GamePanel.gameOver = false;

    }
}
