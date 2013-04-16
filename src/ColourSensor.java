import lejos.nxt.LightSensor;
import lejos.nxt.SensorPort;

/**
 * @author Joram Ruitenschild
 * Abstraction for the light-sensor
 */
public class ColourSensor {
	private static LightSensor lightSensor = new LightSensor(SensorPort.S4);
	
	public static int checkForFaillure() {
		return 1;
	}
	
}
