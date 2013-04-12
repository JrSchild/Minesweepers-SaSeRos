import lejos.nxt.LCD;
import lejos.nxt.Motor;
import lejos.nxt.MotorPort;
import lejos.nxt.NXTMotor;
import lejos.nxt.NXTRegulatedMotor;

public class main {
	public static void main(String[] args) throws InterruptedException {
		Screen.writeLn("oh why");
		Screen.writeLn("oh why");
		
		//printInfoScreen();
		for (int i = 0; i < 3; i++) {
			SonicSensorMotor.lookLeft();
			Thread.sleep(800);
	
			SonicSensorMotor.lookFront();
			Thread.sleep(800);
	
			SonicSensorMotor.lookRight();
			Thread.sleep(800);
			
			SonicSensorMotor.lookLeft();
			Thread.sleep(800);
	
			SonicSensorMotor.lookFront();
			Thread.sleep(800);
		}
		
		SonicSensorMotor.lookFront();
		Thread.sleep(800);
	
	}
	
	public static void printInfoScreen() {
		Screen.clear();
		Screen.writeLn("hello");
		Screen.writeLn("hello");
		Screen.writeLn("hello");
		// Screen.writeLn("sensor 1: " + sensor1.getDistance());
		// Screen.writeLn("sensor 2: " + sensor2.getDistance());
		// Screen.writeLn("motor 1:  " + motor1.isOk());
		// Screen.writeLn("motor 2:  " + motor2.isOk());
	}
}

class SonicSensorMotor {
	private static Direction direction = Direction.FRONT;
	private static NXTRegulatedMotor motor = Motor.C;
	
	public static void turn(int angle) {
		motor.rotate(angle);
	}
	
	public static void lookLeft() {
		int degrees = (direction == Direction.FRONT) ? 100 :
			(direction == Direction.RIGHT) ? 200 : 0;
		direction = Direction.LEFT;
		turn(degrees);
	}
	
	public static void lookFront() {
		int degrees = (direction == Direction.LEFT) ? -100 :
			(direction == Direction.RIGHT) ? 100 : 0;
		direction = Direction.FRONT;
		turn(degrees);
	}
	
	public static void lookRight() {
		int degrees = (direction == Direction.LEFT) ? -200 :
			(direction == Direction.FRONT) ? -100 : 0;
		direction = Direction.RIGHT;
		turn(degrees);
	}
	
}

enum Direction {
	LEFT, FRONT, RIGHT;
}

/**
 * @author Joram Ruitenschild
 * Simple class to write lines to the screen
 */
class Screen {
	private static int lineNo = -1;
	
	public static void writeLn(String line) {
		LCD.drawString(line, 0, ++lineNo);
	}
	
	public static void clear() {
		LCD.clear();
		lineNo = -1;
	}
}
