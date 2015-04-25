
package edu.uwec.cs.kunseljp.program4;

import java.awt.*;
import java.util.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class PaintingPanel extends JPanel {

	public ArrayList<PaintingPrimitive> drawItems = new ArrayList<PaintingPrimitive>();

	public PaintingPanel() {
		setBackground(Color.WHITE);
	}

	// adds a new shape
	public synchronized void addPrimitive(PaintingPrimitive obj) {
		this.drawItems.add(obj);
		repaint();
	}

	// draw the shapes
	public synchronized void paintComponent(Graphics g) {
		super.paintComponent(g);
		for (PaintingPrimitive obj : drawItems) {
			obj.draw(g);
		}
	}

	// method to temporarily draws lines so you can see what the shape will look
	// like once the mouse is released
	public void addTempPrimitive(PaintingPrimitive obj) {
		if (drawItems.size() == 0) {
			this.drawItems.add(obj);
		} else {
			this.drawItems.set(0, obj);
		}
		repaint();
	}

}
