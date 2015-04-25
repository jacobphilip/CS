package edu.cs.rzeszucd.program3;

import java.awt.*;
import java.awt.event.*;

@SuppressWarnings("serial")
public class Paddle extends BreakoutComponent implements MovingComponent {
	static Color c = Color.GREEN;

	// Paddle constructor, implements BreakoutComponent and Moving Component
	public Paddle(int x, int y, int w, int h) {
		super(x, y, w, h, c);
	}

	// Allows for mouse cursor to position at center of paddle
	final int center = (int) ((this.getWidth()) / 2);

	// Updates paddle's y position when mouse moves
	public void updatePosition() {
		collisionCheck();

		Breakout.BP.addMouseMotionListener(new MouseMotionListener() {
			// New mouse action listener to look for mouse movement
			public void mouseDragged(MouseEvent e) {

			}

			// Moves paddle as mouse is moved
			public void mouseMoved(MouseEvent e) {
				Point pt = e.getPoint();
				changeX(pt.x - center);
			}
		});

	}

	// Keeps paddle on BreakoutPanel without going over the boundary
	public void collisionCheck() {
		if (this.x > 440) {
			this.x = 440;
		}

		if (this.x < 10) {
			this.x = 10;
		}
	}
}
