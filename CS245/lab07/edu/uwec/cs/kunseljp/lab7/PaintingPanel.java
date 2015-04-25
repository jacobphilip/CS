package edu.uwec.cs.kunseljp.lab7;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JPanel;

public class PaintingPanel extends JPanel {
	private static final long serialVersionUID = 1L;

	ArrayList<PaintingPrimitave> drawings = new ArrayList<PaintingPrimitave>();

	public void addPrimitive(PaintingPrimitave painting) {
		drawings.add(painting);
	}

	PaintingPanel() {
		this.setBackground(Color.WHITE);
	}

	// overrides paintComponent to get it to do what we want
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		// loops through and paints everything in the ArrayList drawings
		for (PaintingPrimitave painting : drawings) {
			painting.draw(g);
		}
		
	}
}

