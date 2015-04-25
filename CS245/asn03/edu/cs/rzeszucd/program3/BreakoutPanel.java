package edu.cs.rzeszucd.program3;

import java.awt.*;
import java.util.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class BreakoutPanel extends JPanel {
	// List which takes in the components from the level text documents
	public static ArrayList<BreakoutComponent> components = new ArrayList<BreakoutComponent>();

	// BreakoutPanel Constructor
	public BreakoutPanel() {
		setBackground(Color.BLACK);
	}

	@SuppressWarnings("static-access")
	// Adds components from level to components list
	public void addComponents(BreakoutComponent bc) {
		this.components.add(bc);
		repaint();
	}

	// Paints components onto the screen
	public void paintComponent(Graphics g) {
		try {
			super.paintComponent(g);
			for (BreakoutComponent obj : components) {
				obj.draw(g);
			}
		} catch (java.util.ConcurrentModificationException e) {
		}
	}
}
