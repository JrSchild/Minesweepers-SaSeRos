import lejos.nxt.SensorPort;
import lejos.nxt.UltrasonicSensor;

public class SonicSensor {
	public static UltrasonicSensor sonicSensor = new UltrasonicSensor(SensorPort.S1);
	
	public static int checkForFaillure() {
		if (sonicSensor.ping() == 0)
			return 0;
		return 1;
	}
}