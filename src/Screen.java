import java.util.ArrayList;

import lejos.nxt.LCD;

/**
 * @author Joram Ruitenschild
 * Simple class to write lines to the screen
 */
public class Screen {
	private static final int maxHorChars = 16;
	private static final int maxVerChars = 5;
	private static int lineNo = -1;
	private static ArrayList<String> lines = new ArrayList<String>();
	
	public static void writeLn(String line) {
		int s = line.length();
		int l = (int) Math.ceil((float) s / (float) maxHorChars);
		for (int i = 0; i < l; i++) {
			int end = (i * maxHorChars + maxHorChars);
			addLn(line.substring(i * maxHorChars, (end > s ? s : end )));
		}
	}
	
	public static void clear() {
		LCD.clear();
		lines = new ArrayList<String>();
		lineNo = -1;
	}
	
	private static void addLn(String line) {
		lines.add(line);
		if (lines.size() <= maxVerChars) {
			LCD.drawString(line, 0, ++lineNo);
		} else {
			// redraw the whole screen
			LCD.clear();
			int l = lines.size();
			for (int i = l - maxVerChars; i < l; i++) {
				LCD.drawString(lines.get(i), 0, ++lineNo);
			}
		}
	}
}