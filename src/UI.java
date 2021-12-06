import javax.swing.*;
import java.awt.*;

public class UI extends GameComponent{
    private String text;
    private static int score;

    public UI(){
        score = 0;
    }

    @Override
    public void update() {
        text = "Score:  " + score;
    }

    public void paintComponent(Graphics g) {
        g.setColor(Color.black);
        g.setFont(new Font("Impact", Font.PLAIN, 20));
        g.drawString(text, 10,20);
    }

    public static void incrementScore() {
        score ++;
    }

    public static int getScore() {
        return score;
    }
}
