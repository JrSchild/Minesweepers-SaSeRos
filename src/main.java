import java.util.ArrayList;

public class main {
	
	public static void main(String[] args) throws InterruptedException {
		init();
		
		FailureTest.startupTest();
		
		//checkForFailure();
		while(true) {
			//SonicSensor.isObject(Direction.FRONT);
			//Thread.sleep(500);
		}
		
		//printInfoScreen();
		/*for (int i = 0; i < 3; i++) {
			SonicSensorMotor.lookLeft();
			SonicSensorMotor.lookFront();
			SonicSensorMotor.lookRight();
			SonicSensorMotor.lookFront();
		}*/
		
		//Thread.sleep(10000);
		
	}
	
	private static void init() { }
}