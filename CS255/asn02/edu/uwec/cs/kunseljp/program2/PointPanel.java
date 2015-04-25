package edu.uwec.cs.kunseljp.program2;

import java.awt.*;
import java.awt.geom.Point2D;
import java.util.*;
import java.util.List;
import javax.swing.*;

// Panel that displays the points and the hull
public class PointPanel extends JPanel {
	

	private static final long serialVersionUID = 1L;
	private List<Point2D> points;
	private List<Point2D> hullPoints;

	// default constructor
	PointPanel() {
		points = new ArrayList<Point2D>();
		hullPoints = new ArrayList<Point2D>();
	}

	public void paintComponent(Graphics g) {
		// method used to repaint
		super.paintComponent(g);

		// paint the points
		g.setColor(Color.GREEN); // the color of the points

		for (Point2D point1 : points) {
			g.drawOval((int) point1.getX(), (int) point1.getY(), 2, 2);
			g.fillOval((int) point1.getX(), (int) point1.getY(), 2, 2);

		}

		// set default color back to black
		g.setColor(Color.BLACK);

		// paint the hull points
		if ((hullPoints != null) && (hullPoints.size() != 0)) {
			// paint hull only if there is a hull

			g.setColor(Color.RED); // The color of the hull

			// in order to draw a line segment, we need to have a starting point
			Point2D previousPoint = hullPoints.get(0);
			g.drawOval((int) previousPoint.getX(), (int) previousPoint.getY(),
					2, 2);
			g.fillOval((int) previousPoint.getX(), (int) previousPoint.getY(),
					2, 2);

			// for each point in the hull
			for (int i = 1; i < hullPoints.size(); i++) {
				Point2D currentPoint = hullPoints.get(i);

				// draw a point
				g.drawOval((int) currentPoint.getX(),
						(int) currentPoint.getY(), 2, 2);
				g.fillOval((int) currentPoint.getX(),
						(int) currentPoint.getY(), 2, 2);

				// draw a line between the previous point and the current point
				g.drawLine((int) previousPoint.getX(), (int) previousPoint.getY(), (int) currentPoint.getX(), (int) currentPoint.getY());

				// update the value of previousPoint to be this current point
				previousPoint = currentPoint;
			}

			// This is for the final line segment
			g.drawLine((int) hullPoints.get(hullPoints.size() - 1).getX(),
					(int) hullPoints.get(hullPoints.size() - 1).getY(),
					(int) hullPoints.get(0).getX(), (int) hullPoints.get(0)
							.getY());
		}
		
		//set the color back to black
		g.setColor(Color.BLACK);
		
	}

	public List<Point2D> getAllPoints() {
		// This allows other classes to see what the panel's points are
		List<Point2D> returnMe = new ArrayList<Point2D>();

		for (Point2D point1 : this.points) {
			returnMe.add(point1);
		}

		return returnMe;
	}

	public void setHullPoints(List<Point2D> hull) {
		// this allows the panel to get all hull points at once
		this.hullPoints = hull;
	}

	public void addPoint(Point2D aPoint) {
		// this adds a single point to the panel
		this.points.add(aPoint);
	}

	public void clearPoints() {
		// clear all the points
		points = new ArrayList<Point2D>();
		// clear all the hull points
		clearHullPoints();
	}

	public void clearHullPoints() {
		// clear the hull points
		hullPoints = new ArrayList<Point2D>();
	}

}
