package edu.uwec.cs.kunseljp.lab7;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

@SuppressWarnings("serial")
public class Painter extends JFrame implements ActionListener, MouseListener,
		MouseMotionListener {

	private static Color color;
	private static String shape = "";
	private static Point startPoint;
	private static Point endPoint;
	private static PaintingPanel centerPanel = new PaintingPanel();

	public Painter() {
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setSize(500, 500);
		this.repaint();
		JPanel leftPanel = new JPanel();
		leftPanel.setLayout(new GridLayout(3, 1)); // 3 tall by 1 wide

		// add red paint button
		JButton redPaint = new JButton("Red");
		redPaint.setForeground(Color.RED);
		redPaint.setBackground(Color.RED);
		leftPanel.add(redPaint); // Added in next open cell in the grid
		redPaint.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				color = Color.red;
			}

		});

		// Makes the green paint button
		JButton greenPaint = new JButton("Green");
		greenPaint.setBackground(Color.GREEN);
		greenPaint.setForeground(Color.GREEN);
		leftPanel.add(greenPaint);
		greenPaint.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				color = Color.green;
			}

		});

		// Makes the blue paint button
		JButton bluePaint = new JButton("Blue");
		bluePaint.setForeground(Color.BLUE);
		bluePaint.setBackground(Color.BLUE);
		leftPanel.add(bluePaint);
		bluePaint.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				color = Color.blue;
			}

		});

		// Now for the top Line and Circle buttons and panel
		JPanel topPanel = new JPanel();
		topPanel.setLayout(new GridLayout(1, 2)); // 1 tall by 2 wide

		// Makes the line button
		JButton line = new JButton();
		line.setBackground(Color.WHITE);
		line.setText("Line");
		topPanel.add(line);
		line.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				shape = "line";
			}

		});

		// Makes the circle button
		JButton circle = new JButton();
		circle.setBackground(Color.WHITE);
		circle.setText("Circle");
		topPanel.add(circle);
		circle.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				shape = "circle";
			}

		});

		// Makes the square button
		JButton square = new JButton();
		square.setBackground(Color.WHITE);
		square.setText("Rectangle");
		topPanel.add(square);
		square.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				shape = "rectangle";
			}

		});

		// add the panels to the frames ContentPane
		this.add(leftPanel, BorderLayout.WEST);
		this.add(topPanel, BorderLayout.NORTH);

		this.add(centerPanel, BorderLayout.CENTER);
		centerPanel.addMouseListener(this);
		centerPanel.addMouseMotionListener(this);
		this.repaint();
	}

	// Gets the start point
	public void mousePressed(MouseEvent arg0) {
		startPoint = arg0.getPoint();
	}

	public void mouseReleased(MouseEvent arg0) {
		// gets the end point
		endPoint = arg0.getPoint();

		// checks if it's a circle, square, or line, and draws accordingly
		if (shape.equalsIgnoreCase("CIRCLE")) {
			Graphics g = centerPanel.getGraphics();
			PaintingPrimitave circle = new Circle(color, startPoint, endPoint);
			centerPanel.addPrimitive(circle);
			centerPanel.paintComponent(g);
		} else {
			if (shape.equalsIgnoreCase("LINE")) {
				Graphics g = centerPanel.getGraphics();
				PaintingPrimitave line = new Line(color, startPoint, endPoint);
				centerPanel.addPrimitive(line);
				centerPanel.paintComponent(g);
			} else {
				if (shape.equalsIgnoreCase("RECTANGLE")) {
					Graphics g = centerPanel.getGraphics();
					PaintingPrimitave rectangle = new Rectangle(color,
							startPoint, endPoint);
					centerPanel.addPrimitive(rectangle);
					centerPanel.paintComponent(g);
				} else {
					// If the user hasn't entered anything in yet, it tells them
					JOptionPane.showMessageDialog(null, "Please enter a shape");
					if (color == null) {
						JOptionPane.showMessageDialog(null, "Enter a color");
					}
				}
			}
		}
	}

	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
	}

	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
	}

	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
	}

	// draws in the temporary line, circle, or rectangle
//	public void mouseDragged(MouseEvent arg0) {
//		endPoint = arg0.getPoint();
//		if (shape.equalsIgnoreCase("RECTANGLE")) {
//			Graphics g = centerPanel.getGraphics();
//			PaintingPrimitave rectangle1 = new Rectangle(color, startPoint,
//					endPoint);
//			rectangle1.draw(g);
//			this.repaint();
//		} else {
//			if (shape.equalsIgnoreCase("CIRCLE")) {
//				Graphics g = centerPanel.getGraphics();
//				PaintingPrimitave circle = new Circle(color, startPoint,
//						endPoint);
//				circle.draw(g);
//				this.repaint();
//			} else {
//				if (shape.equalsIgnoreCase("LINE")) {
//					Graphics g = centerPanel.getGraphics();
//					PaintingPrimitave line = new Line(color, startPoint,
//							endPoint);
//					line.draw(g);
//					this.repaint();
//				}
//			}
//		}
//	}

	public void mouseMoved(MouseEvent arg0) {
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

	// Main
	public static void main(String[] args) {
		@SuppressWarnings("unused")
		JFrame frame = new Painter();
	}

	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}