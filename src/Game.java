import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Game {
    private static GameFrame gameFrame = new GameFrame();
    private static final int DELAY = 13;
    public static final int ORIGINAL_MOVE_SPEED = 4;
    public static int moveSpeed = 4;
    private static Timer timer;
    private static boolean stopUpdate;

    public static void main(String[] args) {
    	stopUpdate = false;

        timer = new Timer(DELAY, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	if (GamePanel.gameOver) {
                    stopUpdate = true;
                    if (GamePanel.reset) {
                        resetGame();
                    }
                }
                if (GamePanel.reset) {
                    resetGame();
                }
                
                gameFrame.update(stopUpdate);
                
            }
        });
        timer.start();

    }

    public static void resetGame() {
    	stopUpdate = false;
        UI.resetScore();
        gameFrame.reset();
        System.out.println("Should be playing now");
        GamePanel.reset = false;
        GamePanel.gameOver = false;

    }

    public static void setMoveSpeed(int speed) {
        moveSpeed = speed;
    }
}
