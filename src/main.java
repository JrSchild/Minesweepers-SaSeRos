public class main {
	
	public static void main(String[] args) throws InterruptedException {
		init();

		//FailureTest.startupTest();
		SonicSensorMotor.lookRight();
		SonicSensorMotor.lookFront();
		SonicSensorMotor.lookRight();
		SonicSensorMotor.lookFront();
		SonicSensorMotor.lookRight();
		SonicSensorMotor.lookFront();
		SonicSensorMotor.lookRight();
		SonicSensorMotor.lookFront();
		SonicSensorMotor.lookRight();
		SonicSensorMotor.lookFront();
		
		//checkForFailure();
		//while(true) {
			//SonicSensor.isObject(Direction.FRONT);
		//Thread.sleep(1000);
		//}
		
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