

import javax.swing.*;

public class GamePanel extends JPanel {
//    Pillars pillars;
    TestPainting testPainting = new TestPainting();

    GamePanel () {
        this.add(testPainting);
//        pillars = new Pillars(HEIGHT, WIDTH);
//        for (RectangleComponent rectangles: pillars.rectangles) {
//            this.add(rectangles);
//        }
        System.out.println("made it to construcotr of GameFrame");
    }

//    public void addRects() {
//
//    }
//
//    public void update() {
//        pillars.update();
//    }
}
