import lejos.nxt.*;

class Movement{
	
	private Direction lastTurn;
	
	/*
	 * This method makes the robot drive forward or backwards depending on the direction it is given.
	 */
	public void drive(Direction direction){ 	
		if(direction == Direction.FORWARD){
			Motor.A.forward();
			Motor.B.forward();
		}
		else if(direction == Direction.BACKWARDS){
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
	 * This method makes the robot turnNXT 90 deg to the given direction
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
	 * This is a basic turning mechanism depending on the direction it is given.
	 */
	public void wallTurn(Direction fbDirection, Direction lrDirection) throws InterruptedException{
		stop();
		drive(fbDirection);
		Thread.sleep(700);
		turnNXT(lrDirection);
		
	}
	
	/*
	 * This method keeps track of witch direction the robot turned last time.
	 */
	public void setLastTurn(Direction lastturnNXT){
		this.lastTurn = lastturnNXT;
	}
	
	public Direction getLastTurn(){
		return this.lastTurn;
	}
	
	public Direction nextTurn(Direction prevTurn){
		Direction nextTurn = (prevTurn == Direction.LEFT)?Direction.RIGHT:Direction.LEFT;
		return nextTurn;
	}
	
	/*
	 * This method is used to avoid objects.
	 */
	public void avoidObstacle(){
		Direction temp = checkForObstacles();
		Direction nextTurn = nextTurn(temp);
		
		if(temp != Direction.BACKWARDS){
			turnNXT(temp);// turns either right or left depending on the feedback from checkForObstacles()
			// Implement!: turn UltraSonic Sensor in the other direction left = right, right = left.
			drive(Direction.FORWARD);
			Thread.sleep(1500);
			if(checkForObstacles() != temp && checkForObstacles() != Direction.BACKWARDS){ // True if the robot is not cornered
				turnNXT(nextTurn);// Turns the opposite direction so it is able to go around an obstacle(1st turn)
				// Implement!: turn UltraSonic Sensor in the other direction left = right, right = left.
				drive(Direction.FORWARD);
				Thread.sleep(1500);
				if(checkForObstacles() != temp && checkForObstacles() != Direction.BACKWARDS){
					turnNXT(nextTurn);// Turns it once more in the same direction(2nd turn)
					// Implement!: turn UltraSonic Sensor in the other direction left = right, right = left.
					drive(Direction.FORWARD);
					Thread.sleep(1500);
					if(checkForObstacles() != nextTurn && checkForObstacles() != Direction.BACKWARDS){
						turnNXT(temp);// Turns it in the opposite direction(3rd turn)
					}
					else{ // Turns 180 deg
						turnNXT(temp);
						turnNXT(temp);
					}
				}
				else if(checkForObstacles() == temp){
					turnNXT(temp);
				}
				else{ // Turns 180 deg
					turnNXT(temp);
					turnNXT(temp);
				}
			}
			else{ // Turns 90 deg
				turnNXT(temp);
			}
			
		}
		else{ // Turns 180 deg
			turnNXT(temp);
			turnNXT(temp);
		}
			//turnNXT(left or right), drives forward while continously checking left/right.
			//if the sonicsensor returnNXTs a greater int it turnNXTs the given direction.
			//else it turnNXTs the same direction and drives forward.
		//
	}
}