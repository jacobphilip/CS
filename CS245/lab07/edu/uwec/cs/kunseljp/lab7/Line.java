package edu.uwec.cs.kunseljp.lab7;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class Line extends PaintingPrimitave {
	Point startPoint = new Point();
	Point endPoint = new Point();

	public Line(Color color, Point startPoint1, Point endPoint1) {
		super(color);
		startPoint = startPoint1;
		endPoint = endPoint1;
	}

	// draws the line
	public void drawGeometry(Graphics g) {
		g.drawLine(startPoint.x, startPoint.y, endPoint.x, endPoint.y);
	}
}