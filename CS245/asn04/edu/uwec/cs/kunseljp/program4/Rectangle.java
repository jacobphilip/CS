
package edu.uwec.cs.kunseljp.program4;

import java.awt.*;
import java.io.Serializable;

@SuppressWarnings("serial")
public class Rectangle extends PaintingPrimitive implements Serializable {

	protected Point p1;
	protected Point p2;

	public Rectangle(Color color, Point p1, Point p2) {
		super(color);
		this.p1 = p1;
		this.p2 = p2;
	}

	public void drawGeometry(Graphics g) {
		int width = Math.abs(p1.x - p2.x);
		int height = Math.abs(p1.y - p2.y);

		if ((p2.y <= p1.y) && (p2.x <= p1.x)) {
			g.drawRect(p2.x, p2.y, width, height);
		} else if ((p2.y <= p1.y) && (p1.x <= p2.x)) {
			g.drawRect(p1.x, p2.y, width, height);
		} else if ((p1.y <= p2.y) && (p1.x <= p2.x)) {
			g.drawRect(p1.x, p1.y, width, height);
		} else if ((p1.y <= p1.y) && (p2.x <= p1.x)) {
			g.drawRect(p2.x, p1.y, width, height);
		}
	}

}
