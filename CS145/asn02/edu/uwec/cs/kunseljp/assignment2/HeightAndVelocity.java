package edu.uwec.cs.kunseljp.assignment2;

import javax.swing.*;

import java.text.DecimalFormat;

/***********************************************************************/
/* Program to calculate the Height and Velocity of a ball, given the   */
/* initial velocity and initial height                                 */
/* Created by Jacob Kunselman                                          */
/* Date last modified:  11/12/2008                                     */
/***********************************************************************/
public class HeightAndVelocity {

	public static void main(String[] args) {

		// prompts to enter value for height ball thrown
		String inputInitialHeight = JOptionPane
				.showInputDialog(null,
						"Enter the initial height in feet that the ball was thrown from:");
		double initialHeight = Double.parseDouble(inputInitialHeight);

		// prompts to enter value for velocity for ball thrown
		String inputInitialVelocity = JOptionPane
				.showInputDialog(null,
						"Enter the initial velocity in ft/sec squared that the ball was being thrown:");
		double initialVelocity = Double.parseDouble(inputInitialVelocity);

		// Displays dialog box of the string of Time, Height, and Velocity
		// output.
		JOptionPane.showMessageDialog(null, createString(initialHeight,
				initialVelocity));
		// Displays dialog box of the max height and total elapsed time the ball
		// is in the air.
		JOptionPane
				.showMessageDialog(
						null,
						"The maximum height the ball travels to is:\n"
								+ cFormat(maximumHeight(initialHeight,
										initialVelocity))
								+ "\n\nThe total time the ball is in the air is:\n"
								+ cFormat(totalTimeInAir(initialHeight,
										initialVelocity)));
	}

	// declare constant a as 32
	public static final double a = 32.0;

	// return currentHeight from given initial height, initial velocity, and
	// time.
	public static double currentHeight(double initialHeight,
			double initialVelocity, double elapsedTime) {
		double currentHeight = (initialHeight + (initialVelocity * elapsedTime))
				- (Math.pow(elapsedTime, 2.0) * a * 0.5);
		return currentHeight;
	}

	// return maximumHeight from given initial height and initial velocity.
	public static double maximumHeight(double initialHeight,
			double initialVelocity) {
		double timeToMaxHeight = initialVelocity / a;
		double maximumHeight = currentHeight(initialHeight, initialVelocity,
				timeToMaxHeight);
		return maximumHeight;
	}

	// return currentVelocity from given initial velocity and time.
	public static double currentVelocity(double initialVelocity,
			double elapsedTime) {
		double currentVelocity = initialVelocity - (a * elapsedTime);
		return currentVelocity;
	}

	// return totalTimeInAir from given initial height and initial velocity.
	public static double totalTimeInAir(double intitialHeight,
			double initialVelocity) {
		double timeToMaxHeight = initialVelocity / a;
		double timeToFallToGround = Math.pow(((2 * maximumHeight(
				intitialHeight, initialVelocity)) / a), 0.5);
		double totalTimeInAir = timeToMaxHeight + timeToFallToGround;
		return totalTimeInAir;
	}

	// method to create the string described above
	public static String createString(double initialHeight,
			double initialVelocity) {
		// declaring variables
		double elapsedTime = 0.00;
		double curH, curV;
		double totalTimeInAir = totalTimeInAir(initialHeight, initialVelocity);
		// starting string output
		String output = "TIME       HEIGHT   VELOCITY";
		// loop with .25 second intervals and adds the current height and
		// velocity.
		while (totalTimeInAir > elapsedTime) {
			curH = currentHeight(initialHeight, initialVelocity, elapsedTime);
			curV = currentVelocity(initialVelocity, elapsedTime);
			output += "\n" + cFormat(elapsedTime) + "     " + cFormat(curH)
					+ "     " + cFormat(curV);
			elapsedTime += 0.25;
		}
		// adds to output
		output += "\n"
				+ cFormat(totalTimeInAir)
				+ "     "
				+ cFormat(currentHeight(initialHeight, initialVelocity,
						totalTimeInAir)) + "   "
				+ cFormat(currentVelocity(initialVelocity, totalTimeInAir));
		return output;
	}

	// method to format numbers to make them look like 00.00

	static public String cFormat(double value) {

		DecimalFormat myFormatter = new DecimalFormat("00.00");

		String output = myFormatter.format(value);

		return output;

	}

}
