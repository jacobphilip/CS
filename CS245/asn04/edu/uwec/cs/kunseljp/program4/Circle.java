
package edu.uwec.cs.kunseljp.program4;

import java.awt.*;
import java.io.Serializable;

@SuppressWarnings("serial")
public class Circle extends PaintingPrimitive implements Serializable {

	protected Point center;
	protected Point radiusPoint;

	public Circle(Color color, Point center, Point radiusPoint) {
		super(color);
		this.center = center;
		this.radiusPoint = radiusPoint;
	}

	public void drawGeometry(Graphics g) {
		int radius = (int) Math.abs(center.distance(radiusPoint));
		int width = radius * 2;
		int height = radius * 2;
		g.drawOval((center.x - radius), (center.y - radius), width, height);
	}
}
