import lejos.nxt.LightSensor;
import lejos.nxt.SensorPort;

/**
 * @author Joram Ruitenschild
 * Abstraction for the light-sensor
 */
public class ColourSensor {
	private static final String name = "Colour Sensor";
	private static final String port = "S4";
	private static LightSensor lightSensor = new LightSensor(SensorPort.S4);
	
	public static Error checkForFaillure() {
		Error error = new Error(name, port);
		return error;
	}
	
}
