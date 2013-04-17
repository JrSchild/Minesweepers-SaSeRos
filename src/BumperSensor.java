import lejos.nxt.SensorPort;
import lejos.nxt.TouchSensor;

/**
 * @author Joram Ruitenschild
 * Abstraction for the bumper-sensor
 */
public class BumperSensor {
	private static final String name = "Bumper Sensor";
	private static final String port = "S2";
	private static TouchSensor touchSensor = new TouchSensor(SensorPort.S2);

	// test function to see if time gets updated during runtime
	public static void writeTime() {
		while(true) {
			Screen.clear();
			Screen.writeLn("currentTimeMillis: " + System.currentTimeMillis());
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) { }
		}
	}
	
	public static Error checkForFaillure() {
		Error error = new Error(name, port);
		Screen.writeLn("Press the bumper.");
		while (true) {
			if (touchSensor.isPressed())
				return error;
		}
	}
}
