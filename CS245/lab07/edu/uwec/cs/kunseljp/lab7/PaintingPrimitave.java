package edu.uwec.cs.kunseljp.lab7;

import java.awt.*;

public abstract class PaintingPrimitave {
	Color color;

	public PaintingPrimitave(Color c) {
		this.color = c;
	}

	
	public final void draw(Graphics g) {
		g.setColor(this.color);
		drawGeometry(g);
	}

	protected abstract void drawGeometry(Graphics g);
}
