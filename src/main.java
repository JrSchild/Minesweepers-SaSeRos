import java.util.ArrayList;

public class main {
	private static ArrayList<Integer> errors;
	
	public static void main(String[] args) throws InterruptedException {
		init();
		checkForFailure();
		
		//printInfoScreen();
		for (int i = 0; i < 3; i++) {
			SonicSensorMotor.lookLeft();
			SonicSensorMotor.lookFront();
			SonicSensorMotor.lookRight();
			SonicSensorMotor.lookFront();
		}
		
		Thread.sleep(3000);
		
	}
	
	private static void init() { }
	
	private static void checkForFailure() {
		errors = new ArrayList<Integer>();
		
		errors.add(SonicSensor.checkForFaillure());
		Screen.writeLn("SonicSensor: " + SonicSensor.checkForFaillure());
		Screen.writeLn("Press the bumper");
		Screen.writeLn("BumperSensor" + BumperSensor.checkForFaillure());
	}
}