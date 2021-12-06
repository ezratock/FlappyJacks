import javax.swing.*;
import java.awt.*;
import java.util.*;

public class Pillars extends GameComponent {
	private int width;
	private int height;
	private final int NUM_PILLARS = 4;
	private final int MOVE_VALUE = 4;
	private int activePillars = 0;
	private Pillar[] pills = {new Pillar(width, height, false, MOVE_VALUE), new Pillar(width*1.5, height, false, MOVE_VALUE)};
	public RectangleComponent[] rectangles = new RectangleComponent[4];


	public Pillars(int height, int width) {
		this.width = width;
		this.height = height;
		for (int i = 0; i < pills.length; i++) {
			rectangles[i] = pills[i].getLower();
			rectangles[i+2] = pills[i].getUpper();
		}

	}

//	@Override
//	public void paintComponent(Graphics g) {
//		for (Pillar pillar:pills) {
//			pillar.paintComponent(g);
//		}
//	}

	@Override
	public void update() {
		updatePillarLoc();
	}

	public void updatePillarLoc() {
		for (Pillar pillar :pills){
			pillar.update();
			if (pillar.isAtEnd()){
				pillar.reset();
			}
			//if (r.contains(BIRD)){//end game}
		}


	}

//	public void relocatePillar(Pillar pillar) {
//		pillar.resetPillar()
//	}
}
