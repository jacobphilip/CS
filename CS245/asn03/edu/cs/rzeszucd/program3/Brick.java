package edu.cs.rzeszucd.program3;

import java.awt.Color;
import java.awt.geom.*;

@SuppressWarnings("serial")
// Brick constructor, extends BreakoutComponent
public class Brick extends BreakoutComponent {
	static Color c = Color.RED;

	public Brick(int x, int y, int w, int h) {
		super(x, y, w, h, c);

	}

	// Checks collision of ball and bricks
	public void collisionCheck() {
		// Looks at the bricks different sides to decide which way ball bounces
		Line2D top = new Line2D.Double(this.x, this.y, (this.x + this.width),
				(this.y));
		Line2D left = new Line2D.Double(this.x, this.y, (this.x),
				(this.y + this.height));
		Line2D right = new Line2D.Double((this.x + this.height), this.y,
				(this.x + this.width), (this.y + this.height));
		Line2D bottom = new Line2D.Double(this.x, (this.y + this.height),
				(this.x + this.width), (this.y + this.height));

		// changes direction of ball depending on the side hit
		for (int i = 0; i < Breakout.movingC.size(); i++) {
			if ((Breakout.movingC.get(i).getClass().equals(Ball.class))
					&& (this.color != Color.BLACK)) {
				if ((Breakout.movingC.get(i).intersectsLine(top))) {
					((Ball) Breakout.movingC.get(i)).vY *= -1;
				} else if ((Breakout.movingC.get(i).intersectsLine(left))) {
					((Ball) Breakout.movingC.get(i)).vX *= -1;
				} else if ((Breakout.movingC.get(i).intersectsLine(right))) {
					((Ball) Breakout.movingC.get(i)).vX *= -1;
				} else if ((Breakout.movingC.get(i).intersectsLine(bottom))) {
					((Ball) Breakout.movingC.get(i)).vY *= -1;
				}

				// Makes blocks disappear turns them black
				if (this.color != Color.BLACK) {
					this.changeColor(Color.BLACK);
					Breakout.brickCount = Breakout.brickCount - 1;
				}
			}
		}

	}

	// Not used in the brick components
	public void updatePosition() {

	}

}