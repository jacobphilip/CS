package edu.uwec.cs.kunseljp.program2;

import javax.swing.JPanel;
import java.awt.Dimension;
import javax.swing.JTextField;
import java.awt.GridLayout; 
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JRadioButton;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Rectangle;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Point2D;
import java.awt.Point;
import javax.swing.BorderFactory;
import java.awt.ComponentOrientation;


public class Main implements ActionListener, MouseListener {

	private int numPtsDesired;
	private ConvexHullFinder quickHull2 = null;
	private ConvexHullFinder mergeHull2 = null;
	private JFrame outerFrame = null; 
	private JRadioButton quickHull = null;
	private JRadioButton mergeHull = null;
	private JTextField numberOfPts = null;
	private JLabel numPtsLabel = null;
	private JButton genPtsButton = null;
	private JButton genHullButton = null;
	private JPanel leftPanel = null;
	private JPanel mainPanel = null;
	private PointPanel pointPanel1 = null;
	private ConvexHullFinder method = null;
	
	// outer frame
	private JFrame getOuterFrame() {
		if (outerFrame == null) {
			// outer frame contains all components
			outerFrame = new JFrame();
			outerFrame.setBounds(new Rectangle(0, 0, 592, 400));
			outerFrame.setMinimumSize(new Dimension(592, 400));
			outerFrame.setPreferredSize(new Dimension(592, 400));
			outerFrame.setContentPane(getMainPanel());
			outerFrame.setTitle("Convex Hull Finder");
			outerFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			outerFrame.setResizable(false);
			outerFrame.setVisible(true);
		}
		return outerFrame;
	}

	// number of points box
	private JLabel getNumPointsLabel() {
		if (numPtsLabel == null) {
			numPtsLabel = new JLabel();
			numPtsLabel.setText(" Number of points:");
			numPtsLabel.setBounds(new Rectangle(10, 5, 105, 30));
		}
		return numPtsLabel;
	}

	// QuickHull method Button
	private JRadioButton setQuickHull() {
		if (quickHull == null) {
			quickHull = new JRadioButton();
			quickHull.setText("QuickHull");
			quickHull.setSize(new Dimension(90, 30));
			quickHull.setLocation(new Point(55, 140));
			quickHull.addActionListener(this);

			// set the default to quickhull
			quickHull.setSelected(true);
			method = quickHull2;
		}
		return quickHull;
	}

	// MergeHull method Button
	private JRadioButton setMergeHull() {
		if (mergeHull == null) {
			mergeHull = new JRadioButton();
			mergeHull.setText("MergeHull");
			mergeHull.setSize(new Dimension(90, 30));
			mergeHull.setLocation(new Point(55, 170));
			mergeHull.addActionListener(this);
		}
		return mergeHull;
	}

	// Box where user can enter number of points to create
	private JTextField inputPoints() {
		if (numberOfPts == null) {
			numberOfPts = new JTextField();
			numberOfPts.setBounds(new Rectangle(115, 8, 70, 25));
			numberOfPts.setPreferredSize(new Dimension(70, 25));
			numberOfPts.setText("" + 40);
		}
		return numberOfPts;
	}

	// Generate number of points
	private JButton getGenPointsButton() {
		if (genPtsButton == null) {
			genPtsButton = new JButton();
			genPtsButton.setText("Generate Points");
			genPtsButton.setLocation(new Point(22, 40));
			genPtsButton.setSize(new Dimension(150, 35));
			genPtsButton.setPreferredSize(new Dimension(150, 35));
			genPtsButton.addActionListener(this);
		}
		return genPtsButton;
	}

	// The Generate Hull button
	private JButton getGenHullButton() {
		if (genHullButton == null) {
			genHullButton = new JButton();
			genHullButton.setText("Generate Hull");
			genHullButton.setLocation(new Point(22, 90));
			genHullButton.setSize(new Dimension(150, 35));
			genHullButton.setPreferredSize(new Dimension(150, 35));
			genHullButton.addActionListener(this);
		}
		return genHullButton;
	}

	// The left panel
	private JPanel getLeftPanel() {
		if (leftPanel == null) {
			leftPanel = new JPanel();
			leftPanel.setBounds(new Rectangle(7, 8, 296, 354));
			leftPanel.setLayout(null);
			leftPanel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
			leftPanel.setPreferredSize(new Dimension(296, 354));
			leftPanel.add(inputPoints(), null);
			leftPanel.add(getNumPointsLabel(), null);
			leftPanel.add(getGenPointsButton(), null);
			leftPanel.add(setMergeHull(), null);
			leftPanel.add(getGenHullButton(), null);
			leftPanel.add(setQuickHull(), null);

			
			// Makes sure that the two buttons cannot be selected at the same time
			ButtonGroup finderMethodGroup = new ButtonGroup();
			finderMethodGroup.add(mergeHull);
			finderMethodGroup.add(quickHull);

		}
		return leftPanel;
	}

	// The panel holding the left and right panel
	private JPanel getMainPanel() {
		if (mainPanel == null) {
			mainPanel = new JPanel();
			mainPanel.setLayout(null);
			mainPanel.add(getPointPanel(), null);
			mainPanel.add(getLeftPanel(), null);

		}
		return mainPanel;
	}

	// The panel containing the points and hull
	private JPanel getPointPanel() {
		if (pointPanel1 == null) {
			pointPanel1 = new PointPanel();
			pointPanel1.setLayout(new GridLayout());
			pointPanel1.setBounds(new Rectangle(215, 3, 357, 355));
			pointPanel1.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1,Color.black));
			pointPanel1.setPreferredSize(new Dimension(360, 355));
			pointPanel1.setBackground(Color.black);
			pointPanel1.addMouseListener(this);
		}
		return pointPanel1;
	}

	public static void main(String[] args) {

		Main GUI = new Main();

		GUI.quickHull2 = new QuickHull();
		GUI.mergeHull2 = new MergeHull();

		// Displays GUI and centers it
		JFrame me = GUI.getOuterFrame();
		me.setVisible(true);

	}

	public void actionPerformed(ActionEvent arg0) {

		// Set the actions for the buttons

		String action = arg0.getActionCommand();

		// Generate Hull button.
		if (action.equals(genHullButton.getActionCommand())) {

			// clear previous hull
			pointPanel1.clearHullPoints();

			// create new hull
			pointPanel1.setHullPoints(method.computeHull(pointPanel1
					.getAllPoints()));

			// repaint
			pointPanel1.repaint();

			// Generate Points button
		} else if (action.equals(genPtsButton.getActionCommand())) {

			// Gets the number of points from the box

			try {
				numPtsDesired = Integer.parseInt(numberOfPts.getText());

			} catch (Exception e) {
				// ignore anything but a number
			}

			// sets field to last known input
			numberOfPts.setText("" + numPtsDesired);

			// removes the generated points
			pointPanel1.clearPoints();

			// generates some random points
			double randX;
			double randY;

			// this sets our point area inside of the panel
			int panelWidth = pointPanel1.getWidth();
			int panelHeight = pointPanel1.getHeight();

			for (int i = 0; i < numPtsDesired; i++) {
				randX = (Math.random() * 0.80 * panelWidth) + (0.10 * panelWidth);
				randY = (Math.random() * 0.80 * panelHeight) + (0.10 * panelHeight);
				pointPanel1.addPoint(new Point2D.Double(randX, randY));
			}

			// once all points are created, draw the points
			pointPanel1.repaint();

			// sets which method to use
		} else if (action.equals(quickHull.getActionCommand())) {

			method = quickHull2;

		} else if (action.equals(mergeHull.getActionCommand())) {

			method = mergeHull2;

		}

	}

	public void mouseClicked(MouseEvent arg0) {

		// set and point a new point when mouse is clicked in the pointPanel
		pointPanel1.addPoint(new Point2D.Double(arg0.getX(), arg0.getY()));
		pointPanel1.repaint();

	}

	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}
}
