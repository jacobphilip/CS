
package edu.uwec.cs.kunseljp.program4;

import java.awt.*;
import java.io.Serializable;

@SuppressWarnings("serial")
public abstract class PaintingPrimitive implements Serializable {

	protected Color color;

	public PaintingPrimitive(Color color) {
		this.color = color;
	}

	public void draw(Graphics g) {
		g.setColor(this.color);
		drawGeometry(g);
	}

	public void drawGeometry(Graphics g) {
	}

}
