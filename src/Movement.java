import lejos.nxt.*;

class Movement {
	private int[] turnValue = {300,400,255,350,370};
	public static boolean running = true;
	
	/*
	 * This method makes the robot drive FRONT or BACK depending on the direction it is given.
	 */
	public void drive(Direction direction){ 	
		if(direction == Direction.FRONT){
			Motor.A.forward();
			Motor.B.forward();
		}
		else if(direction == Direction.BACK){
			Motor.A.backward();
			Motor.B.backward();
		}
	}
	
	/*
	 * This method makes the robot stop.
	 */
	public void stop(){
		Motor.A.stop();
		Motor.B.stop();
	}
	
	/*
	 * This method makes the robot turn 90 deg to the given direction
	 */
	public void turnNXT(Direction direction){
		if(direction == Direction.RIGHT){
			Motor.A.rotate(237);
			
		}
		else if(direction == Direction.LEFT){
			Motor.B.rotate(237);
		}
	}
	
	/*
	 * This is a basic turning mechanism.
	 * This method is not used!
	 */
	public void easyTurningFunction(){
		stop();
		randomTurn();
	}
	
	private void randomTurn(){
		int rnd = (int) Math.round(Math.random() * (double) 4);
		Motor.A.rotate(turnValue[rnd]);
	}
}