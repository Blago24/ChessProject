/**
 * 
 */
package chess.pieces;

import java.util.ArrayList;

import chess.Board;
import chess.Move;

/**
 * @author Gunnar Atli
 *
 */
public class Rook extends Piece {

	/**
	 * 
	 */
	public Rook(boolean color) {
		super(color);
		value = 5;
	}

	public String toString() {
		if(color == Piece.WHITE)
			return "R";
		else
			return "r";
	}
	
	public Rook clone() {
		return new Rook(color);
	}

	private void checkNorth(Board board,ArrayList<Move> moves,int x,int y){
		for(int i = 1; i < 8; i++) {
			if(valid(x, y+i)) {
				if(board.getTile(x, y+i).isOccupied()) {
					if(board.getTile(x, y+i).getPiece().color != color)
						moves.add(new Move(x,y,x,y+i));

					break;
				}
				else
					moves.add(new Move(x,y,x,y+i));
			}
		}
	}
	private void checkSouth(Board board,ArrayList<Move> moves,int x,int y){
		for(int i = 1; i < 8; i++) {
			if(valid(x, y-i)) {
				if(board.getTile(x, y-i).isOccupied()) {
					if(board.getTile(x, y-i).getPiece().color != color)
						moves.add(new Move(x,y,x,y-i));

					break;
				}
				else
					moves.add(new Move(x,y,x,y-i));
			}
		}
	}
	private void checkWest(Board board,ArrayList<Move> moves,int x,int y){
		for(int i = 1; i < 8; i++) {
			if(valid(x-i, y)) {
				if(board.getTile(x-i, y).isOccupied()) {
					if(board.getTile(x-i, y).getPiece().color != color)
						moves.add(new Move(x,y,x-i,y));

					break;
				}
				else
					moves.add(new Move(x,y,x-i,y));
			}
		}
	}
	private void checkEast(Board board,ArrayList<Move> moves,int x,int y){
		for(int i = 1; i < 8; i++) {
			if(valid(x+i, y)) {
				if(board.getTile(x+i, y).isOccupied()) {
					if(board.getTile(x+i, y).getPiece().color != color)
						moves.add(new Move(x,y,x+i,y));

					break;
				}
				else
					moves.add(new Move(x,y,x+i,y));
			}
		}
	}
	public ArrayList<Move> getMoves(Board board, int x, int y) {
		ArrayList<Move> moves = new ArrayList<Move>();

		checkEast(board,moves,x,y);
		checkNorth(board,moves,x,y);
		checkSouth(board,moves,x,y);
		checkWest(board,moves,x,y);
		return moves;
	}
}
