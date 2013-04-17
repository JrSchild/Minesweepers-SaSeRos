import lejos.nxt.Motor;
import lejos.nxt.NXTRegulatedMotor;

/**
 * @author Joram Ruitenschild
 * Control the motor of the sonic-sensor.
 */
public class SonicSensorMotor {
	private static Direction direction = Direction.FRONT;
	private static NXTRegulatedMotor motor = Motor.C;

	private static final int frontToLeft = 50;
	private static final int frontToRight = 50;
	
	public static void turn(int angle) {
		motor.rotate(angle);
		try {
			Thread.sleep(800);
		} catch (InterruptedException e) { }
	}
	
	public static void lookLeft() {
		int degrees = (direction == Direction.FRONT) ? frontToLeft : 0;
		direction = Direction.LEFT;
		turn(degrees);
	}
	
	public static void lookFront() {
		int degrees = (direction == Direction.LEFT) ? -frontToLeft :
			(direction == Direction.RIGHT) ? frontToRight : 0;
		direction = Direction.FRONT;
		turn(degrees);
	}
	
	public static void lookRight() {
		int degrees = (direction == Direction.FRONT) ? -frontToRight : 0;
		direction = Direction.RIGHT;
		turn(degrees);
	}
	
}