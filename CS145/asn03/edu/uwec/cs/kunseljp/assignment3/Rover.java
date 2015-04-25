package edu.uwec.cs.kunseljp.assignment3;

public class Rover {

	String name;
	int x;
	int y;
	String direction;
	int speed;

	// Constructor
	Rover() {
		name = "default";
		x = 0;
		y = 0;
		direction = "North";
		speed = 0;
	}

	// Rover with parameters
	Rover(String roverName, int xPosition, int yPosition,
			String roverDirection, int roverSpeed) {
		name = roverName;
		x = xPosition;
		y = yPosition;
		direction = roverDirection;
		speed = roverSpeed;
	}

	// setter methods
	void setName(String newRoverName) {
		this.name = newRoverName;
	}

	void setX(int newXPosition) {
		this.x = newXPosition;
	}

	void setY(int newYPosition) {
		this.y = newYPosition;
	}

	void setDirection(String newRoverDirection) {
		this.direction = newRoverDirection;
	}

	void setSpeed(int newRoverSpeed) {
		this.speed = newRoverSpeed;
	}

	// Getter methods
	String getRoverName() {
		return name;
	}

	int getRoverxPosition() {
		return x;
	}

	int getRoveryPosition() {
		return y;
	}

	String getRoverDirection() {
		return direction;
	}

	int getRoverSpeed() {
		return speed;
	}

	// getRoverData
	public String getRoverData() {
		String s = "Rover Name: " + name + "\nX-Position: " + x
				+ "\nY-Position: " + y + "\nDirection: " + direction
				+ "\nSpeed: " + speed;
		return s;
	}

	// display all rover data method
	String displayAllRoverData() {
		String s = "Rover\tX-Position\tY-Position\tDirection\tSpeed (m/sec)\n"
				+ "\n" + name + "\t" + x + "\t" + y + "\t" + direction + "\t"
				+ speed;
		return s;
	}
}
