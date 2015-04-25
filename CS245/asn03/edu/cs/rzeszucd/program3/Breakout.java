package edu.cs.rzeszucd.program3;

import java.awt.*;
import java.io.*;
import java.util.*;
import javax.swing.*;

public class Breakout {
	public static ArrayList<BreakoutComponent> movingC = new ArrayList<BreakoutComponent>();
	public static BreakoutPanel BP;
	public static int brickCount;
	private static final String board = "edu/cs/rzeszucd/program3/board1.txt"; // file location

	public Breakout() {
		// Main JFrame where panels exist
		// Creates GUI for breakout to take place
		JFrame BR = new JFrame();
		BR.setSize(new Dimension(530, 500));
		BR.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());

		JLabel message = new JLabel("Breakout");
		message.setBackground(Color.GRAY);
		panel.add(message, BorderLayout.SOUTH);

		BP = new BreakoutPanel();
		BP.setBackground(Color.BLACK);
		BP.setLayout(new BorderLayout());

		panel.add(BP, BorderLayout.CENTER);
		BR.setContentPane(panel);
		BR.setVisible(true);
		run();

	}

	// Runs instance of breakout
	public static void main(String[] args) {
		new Breakout();

	}

	public void run() {
		readLevel();
		countBricks();
		int sleep = 40;

		// While there is still bricks, updates position of paddle and ball
		while (brickCount != 0) {
			for (int i = 0; i < movingC.size(); i++) {
				movingC.get(i).updatePosition();
			}
			BP.repaint();
			try {
				Thread.sleep((sleep));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			countBricks();
		}

		// Declaration of winner if brick count reaches 0
		if (brickCount == 0) {
			JOptionPane.showMessageDialog(null, "Winner!");
			System.exit(1);
		}

	}

	// method which counts down the bricks that are still in play
	public void countBricks() {
		brickCount = 0;
		for (int i = 0; i < BreakoutPanel.components.size(); i++) {
			if ((BreakoutPanel.components.get(i)).getClass().equals(
					(Brick.class))) {
				if (((Brick) (BreakoutPanel.components.get(i))).color != Color.BLACK) {
					brickCount++;
				}

			}
		}
	}

	// method to read in the level and save the objects to an array
	public void readLevel() {
		try {
			FileReader fr = new FileReader(board);
			BufferedReader br = new BufferedReader(fr);
			String temp = br.readLine();

			// Splits file into seperate parts to create the different parts
			// of the GUI and where they should be placed on the GUI
			while (temp != null) {

				String[] split = temp.split(" ");
				String type = split[0];
				int x = Integer.parseInt(split[1]);
				int y = Integer.parseInt(split[2]);
				int width = Integer.parseInt(split[3]);
				int height = Integer.parseInt(split[4]);

				// Splits, adds to components list, moving components list
				// and creates an instance of it
				if (type.equals("Ball")) {
					Ball b = new Ball(x, y, width, height);
					BP.addComponents(b);
					movingC.add(b);

				} else if (type.equals("Paddle")) {
					Paddle p = new Paddle(x, y, width, height);
					BP.addComponents(p);
					movingC.add(p);

					// Splits, adds to components list and creates an instance
					// of it
				} else if (type.equals("Brick")) {
					BP.addComponents(new Brick(x, y, width, height));
				} else if (type.equals("Wall")) {
					BP.addComponents(new Wall(x, y, width, height));
				} else if (type.equals("KillingWall")) {
					BP.addComponents(new KillingWall(x, y, width, height));
				}
				temp = br.readLine();
			}

			br.close();
			fr.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
