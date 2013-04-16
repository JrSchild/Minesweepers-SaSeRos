import lejos.nxt.LCD;

/**
 * @author Joram Ruitenschild
 * Simple class to write lines to the screen
 */
public class Screen {
	private static int lineNo = -1;
	
	public static void writeLn(String line) {
		LCD.drawString(line, 0, ++lineNo);
	}
	
	public static void clear() {
		LCD.clear();
		lineNo = -1;
	}
}