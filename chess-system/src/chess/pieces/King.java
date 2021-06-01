package chess.pieces;

import boradGame.Board;
import chess.ChessPiece;
import chess.Color;

public class King extends ChessPiece {

	public King(Board board, Color color) {
		super(board, color);
		
	}
	
	@Override
	public String toString() {
		return "K";
	}

	@Override
	public boolean[][] possibleMoves() {
		//Provisional
		boolean [][] mat = new boolean[getBoard().getRows()] [getBoard().getColumns()];
		return mat;
	}

}