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
public class Queen extends Piece {

	/**
	 * 
	 */
	public Queen(boolean color) {
		super(color);
		value = 8;
	}

	public String toString() {
		if(color == Piece.WHITE)
			return "Q";
		else
			return "q";
	}
	
	public Queen clone() {
		return new Queen(color);
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
	private void checkNorthEast(Board board,ArrayList<Move> moves,int x,int y){
// NE
		for(int i = 1; i < 8; i++) {
			if(valid(x+i, y+i)) {
				if(board.getTile(x+i, y+i).isOccupied()) {
					if(board.getTile(x+i, y+i).getPiece().color != color)
						moves.add(new Move(x,y,x+i,y+i));

					break;
				}
				else
					moves.add(new Move(x,y,x+i,y+i));
			}
		}

	}

	private void checkSouthEast(Board board,ArrayList<Move> moves,int x,int y){
		// SE
		for(int i = 1; i < 8; i++) {
			if(valid(x+i, y-i)) {
				if(board.getTile(x+i, y-i).isOccupied()) {
					if(board.getTile(x+i, y-i).getPiece().color != color)
						moves.add(new Move(x,y,x+i,y-i));

					break;
				}
				else
					moves.add(new Move(x,y,x+i,y-i));
			}
		}
	}

	private void checkSouthWest(Board board,ArrayList<Move> moves,int x,int y){
		// SW
		for(int i = 1; i < 8; i++) {
			if(valid(x-i, y-i)) {
				if(board.getTile(x-i, y-i).isOccupied()) {
					if(board.getTile(x-i, y-i).getPiece().color != color)
						moves.add(new Move(x,y,x-i,y-i));

					break;
				}
				else
					moves.add(new Move(x,y,x-i,y-i));
			}
		}

	}

	private void checkNorthWest(Board board,ArrayList<Move> moves,int x,int y){
// NW
		for(int i = 1; i < 8; i++) {
			if(valid(x-i, y+i)) {
				if(board.getTile(x-i, y+i).isOccupied()) {
					if(board.getTile(x-i, y+i).getPiece().color != color)
						moves.add(new Move(x,y,x-i,y+i));

					break;
				}
				else
					moves.add(new Move(x,y,x-i,y+i));
			}
		}
	}
	public ArrayList<Move> getMoves(Board board, int x, int y) {
		ArrayList<Move> moves = new ArrayList<Move>();

		checkEast(board,moves,x,y);
		checkNorth(board,moves,x,y);
		checkSouth(board,moves,x,y);
		checkWest(board,moves,x,y);

		checkNorthEast(board,moves,x,y);
		checkNorthWest(board,moves,x,y);
		checkSouthEast(board,moves,x,y);
		checkSouthWest(board,moves,x,y);
		

		return moves;
	}
}
