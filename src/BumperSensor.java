import lejos.nxt.SensorPort;
import lejos.nxt.TouchSensor;

/**
 * @author Joram Ruitenschild
 * Abstraction for the bumper-sensor
 */
public class BumperSensor {
	private static final String name = "Bumper Sensor";
	private static final String port = "S2";
	private static final int maxPressBumperTime = 10000;
	private static TouchSensor touchSensor = new TouchSensor(SensorPort.S2);
	
	public static Error checkForFaillure() {
		Screen.writeLn("Press the bumper within " + (maxPressBumperTime / 1000) + " seconds");
		long current = System.currentTimeMillis();
		while (true) {
			long diff = (int) (System.currentTimeMillis() - current);
			if (touchSensor.isPressed())
				return null;
			else if (diff > maxPressBumperTime)
				new Error(name, port, true);
		}
	}
}
