import javax.swing.*;
import java.awt.*;
import java.util.*;

public class Pillars extends GameComponent {
	private final int NUM_PILLARS = 4;
	private int activePillars = 0;
	private Pillar[] pills = new Pillar{new Pillar();, }; //creates arraylist of pillars

	public Pillars() {

	}

	@Override
	public void paintComponent(Graphics g) {

	}

	@Override
	public void update() {
		int count = 0;
		for (Rectangle rectangle :pills){
			rectangle.x-=4;
			if (rectangle.x+rectangle.width<=0){
				pills.remove(rectangle);
				count++;
			}
			//if (r.contains(BIRD)){//end game}
			if (count%2 == 0){
				updatePillars();
			}
		}
	}

	public void updatePillars() {

		for (int i = 1; i < NUM_PILLARS; i ++) {
			pills[i*2] = pills[i-2]
		}
	}
}
