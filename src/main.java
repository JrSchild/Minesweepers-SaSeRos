import lejos.nxt.SensorPort;
import lejos.nxt.Sound;
import lejos.nxt.UltrasonicSensor;

public class main {
	
	public static void main(String[] args) throws InterruptedException {
		FailureTest.startupTest();
		Thread failureTestThread = new Thread(new FailureTestThread());
		//failureTestThread.start();
		
		UltrasonicSensor sonicSensor = new UltrasonicSensor(SensorPort.S1);
		
		Movement movement = new Movement();
		int i = 0;
		while(true) {
				movement.drive(Direction.FRONT);
				if (BumperSensor.isPressed()) {
					movement.drive(Direction.BACK);
					Thread.sleep(1000);
					movement.easyTurningFunction();
				} else if (sonicSensor.getDistance() < 30) {
					movement.easyTurningFunction();
				}
				if (++i > 20) {
					SensorPort.S3.activate();
					Sound.beep();
				}
				if (++i > 60) {
					i = 0;
					SensorPort.S3.passivate();
					Sound.beep();
				}
				Thread.sleep(50);
				FailureTest.testForFaillures();
		}
		
	}
}