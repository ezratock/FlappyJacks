package src;
import java.awt.*;

import javax.swing.*;

public class UI extends GameComponent {
    private String text;
    private static String gameOverText;
    private static int score;
    private int highScore = 0;

    public UI() {
    	gameOverText = "";
        score = 0;
        text = "Score: 0";
    }

    @Override
    public void update() {
        updateScoreDisplay();
        updateHighScore();
    }

    public void paintComponent(Graphics g) {
        g.setColor(Color.black);
        g.setFont(new Font("Impact", Font.PLAIN, 20));
        g.drawString(text, 10, 20);
        g.drawString(gameOverText, GameFrame.WIDTH/2 - 100, GameFrame.HEIGHT/2);
    }

    public void updateScoreDisplay() {
        text = "Score:  " + score + "    High Score: " + highScore;
    }

    public static void resetScore() {
        score = 0;
        gameOverText = "";
    }
    
    public static void gameOverDisplay() {
    	gameOverText = "Game Over! Any key to Restart";
    }

    public void updateHighScore() {
        if (this.score > this.highScore)
            this.highScore = this.score;
    }

    public static void incrementScore() {
        score++;
    }

    public static int getScore() {
        return score;
    }

    @Override
    public int[] getProperties() {
        return new int[]{-1, -1, -1, -1};
    }
}
