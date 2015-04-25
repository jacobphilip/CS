package edu.uwec.cs.kunseljp.game;

import java.awt.Graphics;
import javax.swing.JPanel;

public class BoardPanel extends JPanel {

	// needed to remove warning
	private static final long serialVersionUID = 1L;
	TwoPlayerGameBoard board = null;
	
	public BoardPanel(TwoPlayerGameBoard currentBoard) {
		this.board = currentBoard;
	}

	// update active board
	public void setPanel(TwoPlayerGameBoard currentBoard) {
		this.board = currentBoard;
		this.repaint();
	}
	
	// paintComponent Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		if (this.board !=null){
			this.board.draw(g);
		}
	}
	
	
}
