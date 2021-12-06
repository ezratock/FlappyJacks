import javax.swing.*;
import java.awt.*;

public class UI extends GameComponent{
    private String text;
    private int score;

    public UI(){
        this.score = 0;
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

    public void incrementScore() {
        this.score ++;
    }

    public int getScore() {
        return this.score;
    }
}
