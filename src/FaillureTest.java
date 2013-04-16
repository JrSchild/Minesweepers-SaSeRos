import java.lang.annotation.Annotation;

/**
 * @author Joram Ruitenschild
 * Test all Sensors and components
 */
public class FaillureTest {
	
	public static void startupTest() {
		test(SonicSensor.checkForFaillure());
		
	}
	public static void testForFaillures() { }

	public static void test(int error) {
		
	}
}

class Error {
	public boolean hasErrors = false;
	
	public Error() { }
}