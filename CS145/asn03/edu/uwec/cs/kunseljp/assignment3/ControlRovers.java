package edu.uwec.cs.kunseljp.assignment3;

import javax.swing.JOptionPane;

//CS-145 Assignment III
//Jacob Kunselman
//December 12, 2008
public class ControlRovers {

	public static void main(String[] args) {
		String howMany = JOptionPane
				.showInputDialog("How many rovers are there?");
		int RoverCount = Integer.parseInt(howMany);

		Rover[] rovers = new Rover[RoverCount];

		for (int i = 0; i < RoverCount; i++) {
			JOptionPane.showMessageDialog(null, "Enter the info for Rover # "
					+ (i + 1));

			// Name input
			String name = JOptionPane.showInputDialog("Enter rover name:");

			// X Position Check
			String xPosition = JOptionPane.showInputDialog("Enter X position:");
			boolean check = false;
			if (xPosition.matches("[\\d]")) {
				check = true;
			}
			while (!check) {
				xPosition = JOptionPane.showInputDialog(null,
						"X positions must be in the format of a number. "
								+ "\nExample: 0, 1, 10, 14...");
				if (xPosition.matches("[\\d]")) {
					check = true;
				}
			}

			// Y Position Check
			String yPosition = JOptionPane.showInputDialog("Enter Y position:");
			check = false;
			if (yPosition.matches("[\\d]")) {
				check = true;
			}
			while (!check) {
				yPosition = JOptionPane.showInputDialog(null,
						"Y Positions must be in the format of a number. "
								+ "\nExample Inputs: 0, 1, 10, 14...");
				if (yPosition.matches("[\\d]")) {
					check = true;
				}
			}

			// Direction Input
			String direction = "";
			check = false;
			while (!check) {
				direction = JOptionPane
						.showInputDialog("Enter the direction of the rover: (N, S, W, or E)");
				if (direction.matches("N") || direction.matches("S")
						|| direction.matches("W") || direction.matches("E")) {
					check = true;
				}

			}
			// Valid Speed Check
			String speed = JOptionPane
					.showInputDialog("Enter the speed of the rover in m/sec:");
			check = false;
			System.out.println(speed);
			check = speed.matches("[0-5]");
			while (!check) {
				speed = JOptionPane.showInputDialog(null,
						"Speed must be an integer between 0 and 5."
								+ "\nPossible Inputs: 0, 1, 2, 3, 4, and 5.");
				check = speed.matches("[0-5]");
			}
			int x = Integer.parseInt(xPosition);
			int y = Integer.parseInt(yPosition);
			int s = Integer.parseInt(speed);
			rovers[i] = new Rover(name, x, y, direction, s);
		}
		for (int i = 0; i < rovers.length; i++) {
			JOptionPane.showMessageDialog(null, rovers[i].getRoverData());
		}
		displayAllRoverData(rovers);

	}

	private static void displayAllRoverData(Rover[] rovers) {
		StringBuffer SB = new StringBuffer(
				"Rover\tX-Position\tY-Position\tDirection\tSpeed (m/sec)\n");
		for (int i = 0; i < rovers.length; i++) {
			SB = SB.append(rovers[i].getRoverName() + "              "
					+ rovers[i].getRoverxPosition() + "              "
					+ rovers[i].getRoveryPosition() + "              "
					+ rovers[i].getRoverDirection() + "              "
					+ rovers[i].getRoverSpeed() + "\n");

		}
		JOptionPane.showMessageDialog(null, SB);
	}

}
