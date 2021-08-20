package chess.pieces;

import boradGame.Board;
import boradGame.Position;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.Color;

public class King extends ChessPiece {
	
	private ChessMatch chessMatch;
	
	public King(Board board, Color color,ChessMatch chessMatch) {
		super(board, color);
		this.chessMatch = chessMatch;
	}

	@Override
	public String toString() {
		return "K";
	}

	private boolean canMove (Position position) {
		ChessPiece p = (ChessPiece)getBoard().piece(position);
		return p == null || getColor() != getColor();		
	}

	private boolean testRookCastling(Position position) {
		ChessPiece p = (ChessPiece)getBoard().piece(position);
		return p != null &&  p instanceof Rook && p.getColor() == getColor() && p.getMoveCount() == 0;		
	}
	@Override
	public boolean[][] possibleMoves() {
		//Provisional
		boolean [][] mat = new boolean[getBoard().getRows()] [getBoard().getColumns()];

		Position p = new Position(0, 0);

		//Above
		p.setValues(position.getRow() -1, position.getColum());
		if(getBoard().positionExists(p) && canMove(p)) {
			mat [p.getRow()][p.getColum()] = true;
		}

		//Below
		p.setValues(position.getRow() +1, position.getColum());
		if(getBoard().positionExists(p) && canMove(p)) {
			mat [p.getRow()][p.getColum()] = true;
		}

		//left
		p.setValues(position.getRow(), position.getColum()-1);
		if(getBoard().positionExists(p) && canMove(p)) {
			mat [p.getRow()][p.getColum()] = true;
		}

		//Right
		p.setValues(position.getRow(), position.getColum()+1);
		if(getBoard().positionExists(p) && canMove(p)) {
			mat [p.getRow()][p.getColum()] = true;
		}
		
		//nw
		p.setValues(position.getRow()-1, position.getColum()-1);
		if(getBoard().positionExists(p) && canMove(p)) {
			mat [p.getRow()][p.getColum()] = true;
		}
		
		//ne
		p.setValues(position.getRow()-1, position.getColum()+1);
		if(getBoard().positionExists(p) && canMove(p)) {
			mat [p.getRow()][p.getColum()] = true;
		}

		//sw
		p.setValues(position.getRow()+1, position.getColum()-1);
		if(getBoard().positionExists(p) && canMove(p)) {
			mat [p.getRow()][p.getColum()] = true;
		}
		//se
		p.setValues(position.getRow()+1, position.getColum()+1);
		if(getBoard().positionExists(p) && canMove(p)) {
			mat [p.getRow()][p.getColum()] = true;
		}	
		//#Special move castling
		if (getMoveCount()==0 && !chessMatch.getCheck()) {
			//Special move castling King side rook
			Position posT1 = new Position(position.getRow(),position.getColum()+3);
			if (testRookCastling(posT1)) {
				Position p1 = new Position(position.getRow(),position.getColum()+1);
				Position p2 = new Position(position.getRow(),position.getColum()+2);
				if(getBoard().piece(p1)==null && getBoard().piece(p2)==null) {
					mat[position.getRow()][position.getColum()+2]=true;
					
				}
			}
			//Special move castling Queen side rook
			Position posT2 = new Position(position.getRow(),position.getColum()-4);
			if (testRookCastling(posT2)) {
				Position p1 = new Position(position.getRow(),position.getColum()-1);
				Position p2 = new Position(position.getRow(),position.getColum()-2);
				Position p3 = new Position(position.getRow(),position.getColum()-3);
				if(getBoard().piece(p1)==null && getBoard().piece(p2)==null && getBoard().piece(p3)==null) {
					mat[position.getRow()][position.getColum()-2]=true;
					
				}
			}
		}
		
		
		return mat;
	}



}
