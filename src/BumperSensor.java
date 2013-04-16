import lejos.nxt.SensorPort;
import lejos.nxt.TouchSensor;

/**
 * @author Joram Ruitenschild
 * Abstraction for the bumper-sensor
 */
public class BumperSensor {
	private static TouchSensor touchSensor = new TouchSensor(SensorPort.S2);

	public static int checkForFaillure() {
		SensorPort.S3.activate();
		while (true) {
			if (touchSensor.isPressed())
				return 0;
		}
	}
}
