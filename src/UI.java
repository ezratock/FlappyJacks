import javax.swing.*;
import java.awt.*;

public class UI extends GameComponent {
    private String text;
    private static int score;
    private int highScore = 0;

    public UI() {
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
    }

    public void updateScoreDisplay() {
        text = "Score:  " + score + "    High Score: " + highScore;
    }

    public static void resetScore() {
        score = 0;
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
