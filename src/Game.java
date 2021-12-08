import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Game {
    private static GameFrame gameFrame = new GameFrame();
    private static final int DELAY = 10;
    public static final int ORIGINAL_MOVE_SPEED = 4;
    public static int moveSpeed = 4;

    public static void main(String[] args) {

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

    public static void setMoveSpeed(int speed) {
        moveSpeed = speed;
    }
}
