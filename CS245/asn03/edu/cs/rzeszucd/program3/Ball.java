package edu.cs.rzeszucd.program3;

import java.awt.Color;

@SuppressWarnings("serial")
public class Ball extends BreakoutComponent {
	static Color c = Color.BLUE;
	public double vX;// vectors which the ball will bounce off objects at
	public double vY;

	// Ball constructor, supers BreakoutComponent
	public Ball(int x, int y, int w, int h) {
		super(x, y, w, h, c);
		vX = .707;
		vY = .707;
	}

	// Updates position of ball to allow for movement in the breakout panel
	public void updatePosition() {
		collisionCheck();
		this.x += (int) (vX * 10);
		this.y += (int) (vY * 10);

	}

	// Checks if hits all the other components of the game
	public void collisionCheck() {
		int size = BreakoutPanel.components.size();
		for (int i = 0; i < size; i++) {

			// checks if hit KillingWall
			if ((BreakoutPanel.components.get(i)).getClass().equals(
					KillingWall.class)) {
				if (BreakoutPanel.components.get(i).intersects(this)) {
					BreakoutPanel.components.get(i).collisionCheck();
				}
			}
			// checks if hits paddle
			if (BreakoutPanel.components.get(size - 1).intersects(this)) {
				this.vY = -.707;
			}

			// checks if hits wall
			if ((BreakoutPanel.components.get(i)).getClass().equals(
					(Wall.class))) {
				if (BreakoutPanel.components.get(i).intersects(this)) {
					BreakoutPanel.components.get(i).collisionCheck();
				}
			}

			// checks if hits bricks
			if ((BreakoutPanel.components.get(i)).getClass().equals(
					(Brick.class))) {
				if (BreakoutPanel.components.get(i).intersects(this)) {
					BreakoutPanel.components.get(i).collisionCheck();
				}
			}

		}
	}

}
