import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Game {

    public static void main(String[] args) {
        GameFrame gameF = new GameFrame();
        InputHandler inputHandler = new InputHandler();
        gameF.addKeyListener(inputHandler);
    }
    
}
