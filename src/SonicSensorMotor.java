import lejos.nxt.Motor;
import lejos.nxt.NXTRegulatedMotor;

class SonicSensorMotor {
	private static Direction direction = Direction.FRONT;
	private static NXTRegulatedMotor motor = Motor.C;
	
	public static void turn(int angle) {
		motor.rotate(angle);
	}
	
	public static void lookLeft() {
		int degrees = (direction == Direction.FRONT) ? 119 : 0;
		direction = Direction.LEFT;
		turn(degrees);
	}
	
	public static void lookFront() {
		int degrees = (direction == Direction.LEFT) ? -119 :
			(direction == Direction.RIGHT) ? 128 : 0;
		direction = Direction.FRONT;
		turn(degrees);
	}
	
	public static void lookRight() {
		int degrees = (direction == Direction.FRONT) ? -127 : 0;
		direction = Direction.RIGHT;
		turn(degrees);
	}
}

enum Direction {
	LEFT, FRONT, RIGHT;
}