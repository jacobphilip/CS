package edu.cs.rzeszucd.program3;

import java.awt.*;

@SuppressWarnings("serial")
public abstract class BreakoutComponent extends Rectangle implements
		MovingComponent {
	Color color;

	// Breakout Component constructor, extends + supers rectangle class
	public BreakoutComponent(int x, int y, int w, int h, Color c) {
		super(x, y, w, h);
		this.color = c;
	}

	public final void draw(Graphics g) {
		g.setColor(color);
		drawGeometry(g);
	}

	private void drawGeometry(Graphics g) {
		g.fill3DRect(super.x, super.y, super.width, super.height, true);
	}

	// Allows x values to change in the components
	protected void changeX(int x) {
		super.x = x;
	}

	// Allows y values to change in the components
	protected void changeY(int y) {
		super.y = y;
	}

	// Allows color values to change in the components
	protected void changeColor(Color c) {
		this.color = c;
	}

}
