package chess;

import boradGame.Board;
import boradGame.Piece;
import boradGame.Position;

public abstract class ChessPiece extends Piece{
	private Color color;

	public ChessPiece(Board board, Color color) {
		super(board);
		this.color = color;
	}

	public Color getColor() {
		return color;
	}

	protected boolean isThereOpponentPiece(Position position) {
		ChessPiece p = (ChessPiece)getBoard().piece(this.position);
		return p != null && p.getColor() != color;
	}
	
	
}
