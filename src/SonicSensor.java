import lejos.nxt.SensorPort;
import lejos.nxt.UltrasonicSensor;

/**
 * @author Joram Ruitenschild
 * Abstraction for the distance-sensor
 */
public class SonicSensor {
	public static final String name = "Sonic Sensor";
	public static final String port = "S1";
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
			isObject = sonicSensor.getDistance() > 25 ? true : false;
			SonicSensorMotor.lookFront();
		}
		return isObject;
	}
	
	public static int checkForFaillure() {
		if (sonicSensor.ping() == 0)
			return 0;
		return 1;
	}
}