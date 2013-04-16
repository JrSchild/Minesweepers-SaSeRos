import lejos.nxt.SensorPort;
import lejos.nxt.TouchSensor;

public class BumperSensor {
	public static TouchSensor touchSensor = new TouchSensor(SensorPort.S2);

	public static int checkForFaillure() {
		
		SensorPort.S3.activate();
		while (true) {
			if (touchSensor.isPressed())
				return 0;
		}
	}
}
