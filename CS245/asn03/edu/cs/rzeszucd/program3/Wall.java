package edu.cs.rzeszucd.program3;

import java.awt.Color;
import java.awt.geom.Line2D;

@SuppressWarnings("serial")
public class Wall extends BreakoutComponent {
	static Color c = Color.WHITE;

	// Wall constructor extends BreakoutComponent
	public Wall(int x, int y, int w, int h) {
		super(x, y, w, h, c);
	}

	public void updatePosition() {
		// the walls do not move
	}

	public void collisionCheck() {
		// Looks at each individual side of the wall
		Line2D top = new Line2D.Double(this.x, this.y, (this.x + width),
				(this.y));
		Line2D left = new Line2D.Double(this.x + 5, this.y + 5, (this.x + 5),
				(this.y + height + 5));
		Line2D right = new Line2D.Double((this.x + width + 5), this.y + 5,
				(this.x + width + 5), (this.y + height + 5));
		Line2D bottom = new Line2D.Double(this.x, (this.y + height),
				(this.x + width), (this.y + height));

		// Changes ball's direction based on which side of the wall it hits
		for (int i = 0; i < Breakout.movingC.size(); i++) {
			if (Breakout.movingC.get(i).getClass().equals(Ball.class)) {
				if ((Breakout.movingC.get(i).intersectsLine(top))) {
					((Ball) Breakout.movingC.get(i)).vY *= -1;
				} else if (Breakout.movingC.get(i).intersectsLine(left)) {
					((Ball) Breakout.movingC.get(i)).vX *= -1;
				} else if (Breakout.movingC.get(i).intersectsLine(right)) {
					((Ball) Breakout.movingC.get(i)).vX *= -1;
				} else if (Breakout.movingC.get(i).intersectsLine(bottom)) {
					((Ball) Breakout.movingC.get(i)).vY *= -1;
				}
			}
		}

	}
}