import java.awt.*;

public class Pillars extends GameComponent {
    private final int MOVE_SPEED = 4;
    private int moveValue = MOVE_SPEED;
    private Pillar[] pills;
    public RectangleComponent[] rectangles = new RectangleComponent[4];

    public Pillars() {
        pills = new Pillar[]{new Pillar(false, moveValue), new Pillar(true, moveValue)};
        this.setSize(new Dimension(460, 510));
        for (int i = 0; i < pills.length; i++) {
            rectangles[i] = pills[i].getLower();
            rectangles[i + 2] = pills[i].getUpper();
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        for (Pillar pillar : pills) {
            pillar.paintComponent(g);
        }
    }

    @Override
    public void update() {

        updatePillarLoc();
    }

    public void stopMoving() {
        for (Pillar pillar : pills) {
            pillar.setMovePixels(0);
        }
    }

    public void startMoving() {
        for (Pillar pillar : pills) {
            pillar.setMovePixels(MOVE_SPEED);
        }
    }

    public void updatePillarLoc() {
        for (Pillar pillar : pills) {
            pillar.update();
            if (pillar.isAtEnd()) {
                pillar.reset();
            }
            if (pillar.passedBird()) {
                UI.incrementScore();
            }
        }
    }

    public void resetPillars() {
        pills[0].initializePillar(true);
        pills[1].initializePillar(false);
    }

    public RectangleComponent[] getRects() {
        int index = 0;
        RectangleComponent[] returnVar = new RectangleComponent[4];
        for (Pillar pill : pills) {
            returnVar[index] = pill.getUpper();
            returnVar[index + 1] = pill.getLower();
            index += 2;
        }
        return returnVar;
    }

    @Override
    public int[] getProperties() {
        return new int[]{-1, -1, -1, -1};
    }

}