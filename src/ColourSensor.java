import lejos.nxt.SensorPort;
import lejos.nxt.addon.ColorHTSensor;

/**
 * @author Maimuna Syed & Joram Ruitenschild
 * Abstraction for the light-sensor
 */
public class ColourSensor {
	private static final String name = "Colour Sensor";
	private static final String port = "S4";
	private static ColorHTSensor cmps = new ColorHTSensor(SensorPort.S4); // Doesn't work without this?
	
	public static boolean blackDetected() {
		int rawValue = SensorPort.S4.readRawValue();
		if (rawValue > 600 && rawValue < 1000) {
			return true;
		}
		return false;
	}
	
	public static Error checkForFaillure() {
		if (SensorPort.S4.readRawValue() == 1023)
			return new Error(name, port, true);
		return null;
	}
}
