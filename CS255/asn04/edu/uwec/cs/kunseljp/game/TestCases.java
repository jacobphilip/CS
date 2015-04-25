package edu.uwec.cs.kunseljp.game;

public class TestCases {

	public static void main(String[] args) {
		String[][] board = {{" ", " ", " "},
				{"X", "O", "X"},
				{" ", " ", " "}};
		TicTacToeBoard TTTB = new TicTacToeBoard(board, "O");
		MiniMax MM = new MiniMax(999);
		System.out.println(MM.generateNextMove(TTTB));
	}

}


