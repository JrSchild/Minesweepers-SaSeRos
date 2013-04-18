import lejos.nxt.SensorPort;
import lejos.nxt.UltrasonicSensor;

/**
 * @author Joram Ruitenschild
 * Abstraction for the distance-sensor
 */
public class SonicSensor {
	private static final String name = "Sonic Sensor";
	private static final String port = "S1";
	private static UltrasonicSensor sonicSensor = new UltrasonicSensor(SensorPort.S1);
	
	public static Direction checkForObstacles() {
		if (isObject(Direction.LEFT)) {
			return Direction.LEFT;
		}
		if (isObject(Direction.FRONT)) {
			return Direction.FRONT;
		}
		if (isObject(Direction.RIGHT)) {
			return Direction.RIGHT;
		}
		return null;
	}
	
	public static boolean isObject(Direction direction) {
		boolean isObject = false;
		if (direction == Direction.FRONT) {
			isObject = sonicSensor.getDistance() > 25 ? true : false;
		} else {
			if (direction == Direction.LEFT) {
				SonicSensorMotor.lookLeft();
			} else if (direction == Direction.RIGHT) {
				SonicSensorMotor.lookRight();
			}
			isObject = sonicSensor.getDistance() > 70 ? true : false;
			SonicSensorMotor.lookFront();
		}
		return isObject;
	}
	
	public static Error checkForFaillure() {
		if (sonicSensor.ping() == 0)
			return null;
		return new Error(name, port, true);
	}
}