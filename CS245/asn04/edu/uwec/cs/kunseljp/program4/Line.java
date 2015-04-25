
package edu.uwec.cs.kunseljp.program4;

import java.awt.*;
import java.io.Serializable;

@SuppressWarnings("serial")
public class Line extends PaintingPrimitive implements Serializable {

	protected Point point1;
	protected Point point2;

	public Line(Color color, Point p1, Point p2) {
		super(color);
		this.point1 = p1;
		this.point2 = p2;
	}

	public void drawGeometry(Graphics g) {
		g.drawLine(point1.x, point1.y, point2.x, point2.y);
	}
}
