
public class FailureTestThread implements Runnable {

	public void run() {
		while(true) {
			FailureTest.testForFaillures();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) { }
		}
	}
}
