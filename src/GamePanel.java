

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {
    Pillars pillars;
//    TestPainting testPainting = new TestPainting();

    GamePanel (int FRAME_HEIGHT, int FRAME_WIDTH) {
//        this.add(testPainting);
        this.setBackground(Color.CYAN);
//        System.out.println(testPainting.getSize());

        pillars = new Pillars(FRAME_HEIGHT, FRAME_WIDTH);
        this.add(pillars);
//        for (RectangleComponent rectangles: pillars.rectangles) {
//            this.add(rectangles);
//        }
        System.out.println("made it to construcotr of GameFrame");
    }


    public void paint (Graphics g){
        super.paint(g);
        pillars.paintComponent(g);


    }

    public void update() {
        pillars.update();
    }
}
