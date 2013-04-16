import lejos.nxt.LCD;

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