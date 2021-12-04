import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class InputHandler implements KeyListener {
		@Override
		public void keyPressed(KeyEvent key) {
			System.out.println(key.getKeyCode());
			
		}

		@Override
		public void keyReleased(KeyEvent arg0) {
			//pointless
			
		}

		@Override
		public void keyTyped(KeyEvent arg0) {
			//useless
			
		}
    }
