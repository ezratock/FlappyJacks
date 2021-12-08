package src;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.*;

public class Game {
    public static String currentDirectory = new File(new File(".").getAbsolutePath()).getParentFile().getName();
    private static GameFrame gameFrame = new GameFrame();
    private static final int DELAY = 13;
    public static final int ORIGINAL_MOVE_SPEED = 4;
    public static int moveSpeed = 4;
    private static Timer timer;
    private static boolean stopUpdate;
    private static int deathTimeCounter;

    public static void main(String[] args) {
    	deathTimeCounter = 0;
    	stopUpdate = false;
        System.out.println(currentDirectory);

        timer = new Timer(DELAY, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	if (GamePanel.gameOver) {
            		deathTimeCounter += DELAY;
                    stopUpdate = true;
                    if(deathTimeCounter > 700) {
                    	UI.gameOverDisplay();
                    }
                    if (GamePanel.reset && deathTimeCounter > 700) {
                    	deathTimeCounter = 0;
                        resetGame();
                    } else { GamePanel.reset = false; }
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
