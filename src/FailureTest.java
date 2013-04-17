/**
 * @author Joram Ruitenschild
 * Test all Sensors and components
 */
public class FailureTest {
	
	public static void startupTest() {
		test(SonicSensor.checkForFaillure());
		//test(ColourSensor.checkForFaillure());
		test(BumperSensor.checkForFaillure());
	}
	public static void testForFaillures() {
		test(SonicSensor.checkForFaillure());
		test(ColourSensor.checkForFaillure());
	}

	public static void test(Error error) {
		if (error != null && error.isHasErrors()) {
			Screen.writeLn("There's an error for " + error.getName() + ", please check port " + error.getPort() + " and restart.");
			while(true);
		}
	}
}

