package edu.uwec.cs.kunseljp.game;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Point2D;
import javax.swing.*;

public class GamePlayer {

	BoardPanel BP;
	TwoPlayerGameBoard currentBoard;
	int maxlevel = 1;
	private boolean isComputerThinking = false;
	
	//Instance variable you need to add to make the game work
	
	// ***************************************************************************
	// EXTRA METHODS YOU NEED TO ADD TO THIS CLASS
	// ***************************************************************************

	
	// ***************************************************************************
	// EVENT HANDLERS FOR THE GUI PIECES
	// YOU NEED TO FILL IN THE IMPLEMENTATION
	// ***************************************************************************

	public void ticTacToeMenuItem_ActionPerformed(ActionEvent actionEvent) {
		currentBoard = new TicTacToeBoard();
		this.BP.setPanel(currentBoard);
	}

	public void connectFourMenuItem_ActionPerformed(java.awt.event.ActionEvent actionEvent) {
		// Tell user that ConnectFour is not implemented yet.
		JOptionPane.showMessageDialog(null, "Not implemented.");
	}

	// Set difficulty to easy
	public void easyButton_ActionPerformed(ActionEvent actionEvent) {
		this.maxlevel = 1;
	}

	// Set difficulty to medium
	public void mediumButton_ActionPerformed(ActionEvent actionEvent) {
		this.maxlevel = 5;
	}
	
	// Set difficulty to hard
	public void hardButton_ActionPerformed(ActionEvent actionEvent) {
		this.maxlevel = Integer.MAX_VALUE;
	}

	public void boardPanel_MouseReleased(MouseEvent mouseEvent) {
		
		Point2D p = mouseEvent.getPoint();
		try {
			if(this.isComputerThinking == false){
				this.BP.board.placeUserMove(p);
				BP.repaint();
				if(this.BP.board.isUserWinner()){
					JOptionPane.showMessageDialog(null, "Winner!!!");
					BP.setPanel(null);
				}else if(this.BP.board.isDraw()){
					JOptionPane.showMessageDialog(null, "Draw!");
					BP.setPanel(null);
				}else if(this.BP.board.getNextChar().equals("O")){
					ThinkingThread tt = new ThinkingThread(this);
					Thread t = new Thread(tt);
					t.start();
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

	// ***************************************************************************
	// CONSTRUCTOR TO SETUP THE VARIOUS GUI PIECES
	// YOU MAY WANT TO INITIALIZE VARIABLES HERE
	// ***************************************************************************
	public GamePlayer() {
		
		//Setup frame
		JFrame f = new JFrame();
		f.setTitle("Let's Play!");
		f.setSize(800, 855);
		f.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		
		//Setup Menu Bar
		JMenuBar menuBar = new JMenuBar();

		//Game Menu
		JMenu gameMenu = new JMenu();
		gameMenu.setText("Game");

		JMenuItem TTTMI = new JMenuItem();
		TTTMI.setText("TicTacToe");
		gameMenu.add(TTTMI);

		JMenuItem C4MI = new JMenuItem();
		C4MI.setText("ConnectFour");
		gameMenu.add(C4MI);

		menuBar.add(gameMenu);

		//Difficulty Menu
		JMenu diffMenu = new JMenu();
		diffMenu.setText("Difficulty");

		JRadioButtonMenuItem easyMI = new JRadioButtonMenuItem();
		easyMI.setText("Easy");
		easyMI.setSelected(true);
		diffMenu.add(easyMI);

		JRadioButtonMenuItem medMI = new JRadioButtonMenuItem();
		medMI.setText("Medium");
		diffMenu.add(medMI);

		JRadioButtonMenuItem hardMI = new JRadioButtonMenuItem();
		hardMI.setText("Impossible");
		diffMenu.add(hardMI);

		ButtonGroup bg = new ButtonGroup();
		bg.add(easyMI);
		bg.add(medMI);
		bg.add(hardMI);
		
		menuBar.add(diffMenu);
		f.setJMenuBar(menuBar);

		//Setup Board Panel
		currentBoard = null;
		BP = new BoardPanel(currentBoard);
		BP.setBackground(Color.black);
		f.setContentPane(BP);

		//Listeners
		//Mouse Listener for user's placement of game piece
		BP.addMouseListener(new MouseAdapter() {
			public void mouseReleased(MouseEvent e) {
				boardPanel_MouseReleased(e);
			};
		});
		//Menu Item Listeners
		TTTMI.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ticTacToeMenuItem_ActionPerformed(e);
			};
		});
		C4MI.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				connectFourMenuItem_ActionPerformed(e);
			};
		});
		easyMI.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				easyButton_ActionPerformed(e);
			};
		});
		medMI.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mediumButton_ActionPerformed(e);
			};
		});
		hardMI.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				hardButton_ActionPerformed(e);
			};
		});
		
		f.setVisible(true);		
		
		//YOUR INITIALIZE CODE GOES HERE
		//SET ANY VARIABLES THAT YOU WANT INITIALIZED AT THE START HERE
	}
	
	public static void main(String[] args) {
		GamePlayer g = new GamePlayer();
	}

	public void computerDone(TwoPlayerGameBoard generateNextMove) {
		this.isComputerThinking = true;
		this.BP.setPanel(generateNextMove);
		if (this.BP.board.isComputerWinner()) {
			// Display lose
			JOptionPane.showMessageDialog(null, "You LOSE!!");
			this.BP.setPanel(null);
		} else if (this.BP.board.isDraw()) {
			// Display draw
			JOptionPane.showMessageDialog(null, "DRAW!!");
			this.BP.setPanel(null);
		}
		this.isComputerThinking = false;
	}

}
