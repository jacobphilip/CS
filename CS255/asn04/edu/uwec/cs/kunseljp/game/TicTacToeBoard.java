package edu.uwec.cs.kunseljp.game;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.awt.geom.Point2D;

public class TicTacToeBoard implements TwoPlayerGameBoard {

	// class variables
	String[][] board;
	String nextChar = "";
	int boardColumn = 0;
	int boardRow = 0;
	final Stroke stroke = new BasicStroke(10);
	final Color color = Color.white;
	final Color xColor = Color.green;
	final Color yColor = Color.red;
	
	final int WIDTH = 800;
	final int HEIGHT = 800;
	final int OFFSET = 20;

	// no-arg constructor
	public TicTacToeBoard(){
		this.board = new String[3][3];
		for (int i = 0; i < this.board.length; i++){
			for (int j = 0; j < this.board.length; j++){
				this.board[i][j] = " ";
			}
		}
	}
	
	// constructor
	public TicTacToeBoard(String[][] board, String nextChar){
		this.board = new String[3][3];
		for (int i = 0; i < board.length; i++){
			for (int j = 0; j < board.length; j++){
				this.board[i][j] = board[i][j];
			}
		}
		this.nextChar = nextChar;
	}
	
	// copy constructor
	public TicTacToeBoard(TicTacToeBoard TTTB) {
		this.board = new String[3][3];
		for (int i = 0; i < TTTB.board.length; i++){
			for (int j = 0; j < TTTB.board.length; j++){
				this.board[i][j] = TTTB.board[i][j];
			}
		}
		this.nextChar = TTTB.nextChar;
		this.boardColumn = 0;
		this.boardRow = 0;
	}
	
	// find if the board has more children
	public boolean hasMoreChildren(){
		return !isFilled() && !isComputerWinner() && !isUserWinner() && 
			(this.boardColumn < this.board.length);
	}
	
	// find out what the next child is
	public TicTacToeBoard nextChild() {
		// Make a copy of this
		TicTacToeBoard child = new TicTacToeBoard(this);

		// Modify board
		if (child.board[this.boardColumn][this.boardRow].equals(" ")) {
			child.board[this.boardColumn][this.boardRow] = child.nextChar;
			child.nextChar = (child.nextChar.equals("X")) ? "O" : "X";
			this.boardRow++;
			if (this.boardRow == 3) {
				this.boardRow = 0;
				this.boardColumn++;
			}
			return child;
		} else {
			this.boardRow++;
			if (this.boardRow == 3) {
				this.boardRow = 0;
				this.boardColumn++;
			}
			if (this.hasMoreChildren()) {
				return this.nextChild();
			} else {
				return null;
			}
		}
	}
	
	// toString
	public String toString() {
		String s = "";
		for (int i = 0; i < this.board.length; i++) {
			for (int j = 0; j < this.board.length; j++) {
				s += this.board[i][j];
				s += "|";
			}
			s += "\n";
		}
		return s;
	}
	
	public double evaluateValue() {
		int rtrn = 0;
		if (this.board != null){
			if (this.isComputerWinner()){
				rtrn = rtrn + 1;
			} else if (this.isUserWinner()){
				rtrn = rtrn - 1;
			}
		}
		return rtrn;
	}
	
	public boolean isUserWinner() {
		// Check for computer win
		boolean rtrn = false;
		// Top row
		if (this.board[0][0].equals("X") && this.board[0][1].equals("X")
				&& this.board[0][2].equals("X")) {
			rtrn = true;
		}
		// Left side
		if (this.board[0][0].equals("X") && this.board[1][0].equals("X")
				&& this.board[2][0].equals("X")) {
			rtrn = true;
		}
		// Diagonal top-left
		if (this.board[0][0].equals("X") && this.board[1][1].equals("X")
				&& this.board[2][2].equals("X")) {
			rtrn = true;
		}
		// Middle vertical
		if (this.board[0][1].equals("X") && this.board[1][1].equals("X")
				&& this.board[2][1].equals("X")) {
			rtrn = true;
		}
		// Right side
		if (this.board[0][2].equals("X") && this.board[1][2].equals("X")
				&& this.board[2][2].equals("X")) {
			rtrn = true;
		}
		// Middle row
		if (this.board[1][0].equals("X") && this.board[1][1].equals("X")
				&& this.board[1][2].equals("X")) {
			rtrn = true;
		}
		// Bottom row
		if (this.board[2][0].equals("X") && this.board[2][1].equals("X")
				&& this.board[2][2].equals("X")) {
			rtrn = true;
		}
		// Diagonal bottom-left
		if (this.board[2][0].equals("X") && this.board[1][1].equals("X")
				&& this.board[0][2].equals("X")) {
			rtrn = true;
		}
		return rtrn;
	}
	
	public boolean isComputerWinner() {
		// Check for computer win
		boolean rtrn = false;
		// Top row
		if (this.board[0][0].equals("O") && this.board[0][1].equals("O")
				&& this.board[0][2].equals("O")) {
			rtrn = true;
		}
		// Left side
		if (this.board[0][0].equals("O") && this.board[1][0].equals("O")
				&& this.board[2][0].equals("O")) {
			rtrn = true;
		}
		// Diagonal top-left
		if (this.board[0][0].equals("O") && this.board[1][1].equals("O")
				&& this.board[2][2].equals("O")) {
			rtrn = true;
		}
		// Middle vertical
		if (this.board[0][1].equals("O") && this.board[1][1].equals("O")
				&& this.board[2][1].equals("O")) {
			rtrn = true;
		}
		// Right side
		if (this.board[0][2].equals("O") && this.board[1][2].equals("O")
				&& this.board[2][2].equals("O")) {
			rtrn = true;
		}
		// Middle row
		if (this.board[1][0].equals("O") && this.board[1][1].equals("O")
				&& this.board[1][2].equals("O")) {
			rtrn = true;
		}
		// Bottom row
		if (this.board[2][0].equals("O") && this.board[2][1].equals("O")
				&& this.board[2][2].equals("O")) {
			rtrn = true;
		}
		// Diagonal bottom-left
		if (this.board[2][0].equals("O") && this.board[1][1].equals("O")
				&& this.board[0][2].equals("O")) {
			rtrn = true;
		}
		return rtrn;
	}
	
	public boolean isDraw() {
		return (this.isFilled() && (!this.isUserWinner() || !this
				.isComputerWinner()));
	}
	
	// see if the board is full
	public boolean isFilled() {
		for (int i = 0; i < this.board.length; i++) {
			for (int j = 0; j < this.board.length; j++) {
				if (this.board[i][j].equals(" ")) {
					return false;
				}
			}
		}
		return true;
	}
	
	// method to draw the board
	public void draw(Graphics G) {
		Graphics2D g = (Graphics2D) G;
		g.setStroke(this.stroke);
		g.setColor(this.color);
		// Draw the grid
		g.drawLine(this.WIDTH / 3, 0, this.WIDTH / 3, this.HEIGHT);
		g.drawLine((this.WIDTH / 3) * 2, 0, (this.WIDTH / 3) * 2, this.HEIGHT);
		g.drawLine(0, this.HEIGHT / 3, this.WIDTH, this.HEIGHT / 3);
		g.drawLine(0, (this.HEIGHT / 3) * 2, this.WIDTH, (this.HEIGHT / 3) * 2);
		// Draw the X's and O's in the board
		for (int i = 0; i < this.board.length; i++){
			for (int j = 0; j < this.board.length; j++){
				if(this.board[i][j].equals("X")){
					g.setColor(this.xColor);
					g.drawLine(i * (this.WIDTH / 3) + this.OFFSET, j * (this.HEIGHT / 3) + this.OFFSET, (i * (this.WIDTH / 3)) + (this.WIDTH / 3) - this.OFFSET, (j * (this.HEIGHT / 3)) + (this.HEIGHT / 3) - this.OFFSET);
					g.drawLine(i * (this.WIDTH / 3) + this.OFFSET, j * (this.HEIGHT / 3) + (this.HEIGHT / 3) - this.OFFSET, (i * (this.WIDTH / 3)) + (this.WIDTH / 3) - this.OFFSET, j * (this.HEIGHT / 3) + this.OFFSET);
				} else if (this.board[i][j].equals("O")){
					g.setColor(this.yColor);
					g.drawOval(i * (this.WIDTH / 3) + this.OFFSET, j * (this.HEIGHT / 3) + this.OFFSET, (this.WIDTH / 3) - (2 * this.OFFSET), (this.HEIGHT / 3) - (2 *this.OFFSET));
				
				}
			}
		}
		
	}

	// Set move on mouse location
	public void placeUserMove(Point2D mouseLocation) throws Exception {
		double x = mouseLocation.getX();
		double y = mouseLocation.getY();
		
		int i = (int)(x / (this.WIDTH / 3));
		int j = (int)(y / (this.WIDTH / 3)); 
		
		if(this.board[i][j].equals(" ")){
			this.board[i][j] = "X";
			this.nextChar = "O";
		}	
	}
	
	// Method to determine whose turn it is
	public String getNextChar() {
		return this.nextChar;
	}
	
	public void reset(){
		this.boardColumn = 0;
		this.boardRow = 0;
	}
}
