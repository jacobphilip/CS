package edu.uwec.cs.kunseljp.lab7;

import java.awt.*;

public class Circle extends PaintingPrimitave {
	Point center = new Point();
	Point radiusPoint = new Point();

	public Circle(Color color, Point center1, Point radiusPoint1) {
		super(color);
		center = center1;
		radiusPoint = radiusPoint1;
	}

	// Draws the circle
	public void drawGeometry(Graphics g) {
		int radius = (int) Math.abs(center.distance(radiusPoint));
		int width = radius*2;
        int height = radius*2;
        g.drawOval((center.x - radius), (center.y - radius), width, height);   
	}
}
