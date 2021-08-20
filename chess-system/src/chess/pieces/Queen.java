package chess.pieces;

import boradGame.Board;
import boradGame.Position;
import chess.ChessPiece;
import chess.Color;

public class Queen extends ChessPiece {

	public Queen(Board board, Color color) {
		super(board, color);

	}

	@Override
	public String toString() {
		return "Q";
	}

	@Override
	public boolean[][] possibleMoves() {
		//Provisional
		boolean [][] mat = new boolean[getBoard().getRows()] [getBoard().getColumns()];

		Position p = new Position (0,0);

		//Above
		p.setValues(position.getRow()- 1, position.getColum());

		while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
			mat[p.getRow()][p.getColum()]= true;
			p.setRow(p.getRow()-1);
		}
		if(getBoard().positionExists(p) && isThereOpponentPiece(p)) {
			mat[p.getRow()][p.getColum()]= true;
		}

		//Left
		p.setValues(position.getRow(), position.getColum()-1);

		while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
			mat[p.getRow()][p.getColum()]= true;
			p.setColum(p.getColum()-1);
		}
		if(getBoard().positionExists(p) && isThereOpponentPiece(p)) {
			mat[p.getRow()][p.getColum()]= true;
		}
		
		//Right
		p.setValues(position.getRow(), position.getColum()+1);

		while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
			mat[p.getRow()][p.getColum()]= true;
			p.setColum(p.getColum()+1);
		}
		if(getBoard().positionExists(p) && isThereOpponentPiece(p)) {
			mat[p.getRow()][p.getColum()]= true;
		}
		
		//below
		p.setValues(position.getRow()+1, position.getColum());

		while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
			mat[p.getRow()][p.getColum()]= true;
			p.setRow(p.getRow()+1);
		}
		if(getBoard().positionExists(p) && isThereOpponentPiece(p)) {
			mat[p.getRow()][p.getColum()]= true;
		}
		
		//nw
		p.setValues(position.getRow()- 1, position.getColum());

		while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
			mat[p.getRow()][p.getColum()]= true;
			p.setValues(p.getRow()-1,p.getColum()-1);
		}
		if(getBoard().positionExists(p) && isThereOpponentPiece(p)) {
			mat[p.getRow()][p.getColum()]= true;
		}

		//ne
		p.setValues(position.getRow()-1, position.getColum()+1);
		while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
			mat[p.getRow()][p.getColum()]= true;
			p.setValues(p.getRow()-1, p.getColum()+1);;
		}
		if(getBoard().positionExists(p) && isThereOpponentPiece(p)) {
			mat[p.getRow()][p.getColum()]= true;
		}
		
		//se
		p.setValues(position.getRow()+1, position.getColum()+1);
		while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
			mat[p.getRow()][p.getColum()]= true;
			p.setValues(p.getRow()+1, p.getColum()+1);;
		}
		if(getBoard().positionExists(p) && isThereOpponentPiece(p)) {
			mat[p.getRow()][p.getColum()]= true;
		}
		
		//sw
		p.setValues(position.getRow()+1, position.getColum()-1);
		while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
			mat[p.getRow()][p.getColum()]= true;
			p.setValues(p.getRow()+1, p.getColum()-1);
		}
		if(getBoard().positionExists(p) && isThereOpponentPiece(p)) {
			mat[p.getRow()][p.getColum()]= true;
		}	
		
		
		
		return mat;
	}

}
