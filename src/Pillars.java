import javax.swing.*;
import java.awt.*;
import java.util.*;

public class Pillars extends GameComponent {
	private final int MOVE_VALUE = 4;
	private Pillar[] pills;
	public RectangleComponent[] rectangles = new RectangleComponent[4];

	public Pillars(int FWIDTH, int FHEIGHT) {
		pills = new Pillar[]{new Pillar(FWIDTH, FHEIGHT, true, MOVE_VALUE), new Pillar(FWIDTH, FHEIGHT, false, MOVE_VALUE)};
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

	public RectangleComponent[] getRects(){
		int index = 0;
		RectangleComponent[] returnVar = new RectangleComponent[4];
		for (Pillar pill: pills) {
			returnVar[index] = pill.getUpper();
			returnVar[index+1] = pill.getLower();
			index += 2;
		}
		return returnVar;
	}

	@Override
	public int[] getProperties(){
		return new int[]{-1,-1,-1,-1};
	}

}