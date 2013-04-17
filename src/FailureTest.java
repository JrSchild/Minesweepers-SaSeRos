import java.util.ArrayList;

/**
 * @author Joram Ruitenschild
 * Test all Sensors and components
 */
public class FailureTest {
	private static ArrayList<Error> errors;
	
	public static boolean startupTest() {
		test(SonicSensor.checkForFaillure());
		test(ColourSensor.checkForFaillure());
		test(BumperSensor.checkForFaillure());
		return FailureTest.hasErrors();
	}
	public static boolean testForFaillures() {
		test(SonicSensor.checkForFaillure());
		test(ColourSensor.checkForFaillure());
		return FailureTest.hasErrors();
	}

	public static void test(Error error) {
		if (error.isHasErrors()) {
			Screen.writeLn("There's an error for sensor " + error.getName() + ", please check port " + error.getPort() + " and restart.");
			errors.add(error);
		}
	}
	
	public static boolean hasErrors() {
		for (Error e : errors) {
			if (e.isHasErrors())
				return true;
		}
		return false;
	}
}

