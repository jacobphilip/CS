package edu.cs.rzeszucd.program3;

import java.awt.Color;

import javax.swing.JOptionPane;

@SuppressWarnings("serial")
// Killing wall constructor class, extends BreakoutComponent
public class KillingWall extends BreakoutComponent {
	static Color c = Color.GRAY;

	public KillingWall(int x, int y, int w, int h) {
		super(x, y, w, h, c);

	}

	// If ball hits killingwall, dies and shows JPane stating game over
	public void collisionCheck() {
		JOptionPane.showMessageDialog(null, "Game Over");
		System.exit(0);
	}

	// Does not update position on screen
	public void updatePosition() {

	}
}
