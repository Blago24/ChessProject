/**
 * 
 */
package chess.pieces;

import java.util.ArrayList;

import chess.*;


/**
 * @author Gunnar Atli
 *
 */
public class Bishop extends Piece {

	public Bishop(boolean color) {
		super(color);
		value = 3;
	}
	
	public String toString() {
		if(color == Piece.WHITE)
			return "B";
		else
			return "b";
	}
	
	public Bishop clone() {
		return new Bishop(color);
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
		
		checkNorthEast(board,moves,x,y);
		checkNorthWest(board,moves,x,y);
		checkSouthEast(board,moves,x,y);
		checkSouthWest(board,moves,x,y);
		return moves;
	}
}
