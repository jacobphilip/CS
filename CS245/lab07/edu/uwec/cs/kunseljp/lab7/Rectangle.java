package edu.uwec.cs.kunseljp.lab7;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class Rectangle extends PaintingPrimitave{
	Point startPoint = new Point();
	Point endPoint = new Point();
	public Rectangle(Color color, Point startPoint1, Point endPoint1) {
		super(color);
		startPoint = startPoint1;
		endPoint = endPoint1;
	}
	
	//Makes the rectangle
	public void drawGeometry(Graphics g) {
		int end = Math.abs(endPoint.x-startPoint.x);
		int endy = Math.abs(endPoint.y-startPoint.y);
		g.drawRect(startPoint.x, startPoint.y, end, endy);
	}

}