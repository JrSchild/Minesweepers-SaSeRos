import lejos.nxt.*;

class Movement{
	
	private Direction lastTurn = Direction.LEFT;
<<<<<<< HEAD
	private int[] turnValue = {240,245,255,260,270};
=======
	private int[] turnValue = {300,400,255,350,370};
>>>>>>> adding some stuff
	
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
<<<<<<< HEAD
		int rnd = Math.random() * 4;
=======
		int rnd = (int) Math.round(Math.random() * (double) 4);
>>>>>>> adding some stuff
		Motor.A.rotate(turnValue[rnd]);
	}
	
	/*
	 * This method keeps track of witch direction the robot turned last time.
	 */
	public void setLastTurn(Direction lastTurn){
		this.lastTurn = lastTurn;
	}
	
	public Direction getLastTurn(){
		return this.lastTurn;
	}
	
	/*
	 * This method uses the UltraSonic Sensor to check for obstacles in its path.
	 * The method returns a direction.
	 */
<<<<<<< HEAD
	public static Direction checkForObstacles(){
		Direction turn;
=======
	public Direction checkForObstacles(){
		Direction turn = Direction.LEFT;
>>>>>>> adding some stuff
		boolean left = SonicSensor.isObject(Direction.LEFT);
		boolean front = SonicSensor.isObject(Direction.FRONT);
		boolean right = SonicSensor.isObject(Direction.RIGHT);
		
		if(!left && !right){
			turn = getLastTurn(); 
		}
		else if(left && right){
			turn = Direction.BACK;
		}
		else if(left && !right){
			turn = Direction.RIGHT;
		}
		else if(!left && right){
			turn = Direction.LEFT;
		}
		return turn;	
	}
	
	/*
	 * This is a helping method for the avoidObstacle() method.
	 * it returns a direction.
	 */
	public Direction nextTurn(Direction prevTurn){
		Direction nextTurn = (prevTurn == Direction.LEFT)?Direction.RIGHT:Direction.LEFT;
		return nextTurn;
	}
	
	/*
	 * This method is used to avoid objects.
	 */
<<<<<<< HEAD
	public void avoidObstacle(){
=======
	public void avoidObstacle() throws InterruptedException{
>>>>>>> adding some stuff
		Direction temp = checkForObstacles();
		Direction nextTurn = nextTurn(temp);
		if(temp != null){
			if(temp != Direction.BACK){
				turnNXT(temp);// turns either right or left depending on the feedback from SonicSensor.checkForObstacles()
				// Implement!: turn UltraSonic Sensor in the other direction left = right, right = left.
				drive(Direction.FRONT);
				Thread.sleep(1500);
				if(checkForObstacles() != temp && checkForObstacles() != Direction.BACK){ // True if the robot is not cornered
					turnNXT(nextTurn);// Turns the opposite direction so it is able to go around an obstacle(1st turn)
					// Implement!: turn UltraSonic Sensor in the other direction left = right, right = left.
					drive(Direction.FRONT);
					Thread.sleep(1500);
					if(checkForObstacles() != temp && checkForObstacles() != Direction.BACK){
						turnNXT(nextTurn);// Turns it once more in the same direction(2nd turn)
						// Implement!: turn UltraSonic Sensor in the other direction left = right, right = left.
						drive(Direction.FRONT);
						Thread.sleep(1500);
						if(checkForObstacles() != nextTurn && checkForObstacles() != Direction.BACK){
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
		}	
	}
}