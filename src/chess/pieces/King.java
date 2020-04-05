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
public class King extends Piece {
	boolean hasMoved = false;

	/**
	 * 
	 */
	public King(boolean color) {
		super(color);
		value = 0;
	}
	
	public King(boolean color, boolean hasMoved) {
		super(color);
		this.hasMoved = hasMoved;
		value = 0;
	}
	
	public King clone() {
		return new King(color, hasMoved);
	}
	
	public String toString() {
		if(color == Piece.WHITE)
			return "K";
		else
			return "k";
	}
	private void checkNorth(Board board,ArrayList<Move> moves,int x,int y){
		// N
		if(valid(x, y+1) &&
				(!board.getTile(x, y+1).isOccupied() ||
						(board.getTile(x, y+1).isOccupied() && board.getTile(x, y+1).getPiece().getColor() != color)))
			moves.add(new Move(x,y,x,y+1));

	}
	private void checkNorthEast(Board board,ArrayList<Move> moves,int x,int y){
// NE
		if(valid(x+1, y+1) &&
				(!board.getTile(x+1, y+1).isOccupied() ||
						(board.getTile(x+1, y+1).isOccupied() && board.getTile(x+1, y+1).getPiece().getColor() != color)))
			moves.add(new Move(x,y,x+1,y+1));

	}
	private void checkEast(Board board,ArrayList<Move> moves,int x,int y){
// E
		if(valid(x+1,y) &&
				(!board.getTile(x+1,y).isOccupied() ||
						(board.getTile(x+1,y).isOccupied() && board.getTile(x+1,y).getPiece().getColor() != color)))
			moves.add(new Move(x,y,x+1,y));

	}
	private void checkSouthEast(Board board,ArrayList<Move> moves,int x,int y){
// SE
		if(valid(x+1,y-1) &&
				(!board.getTile(x+1,y-1).isOccupied() ||
						(board.getTile(x+1,y-1).isOccupied() && board.getTile(x+1,y-1).getPiece().getColor() != color)))
			moves.add(new Move(x,y,x+1,y-1));

	}
	private void checkSouth(Board board,ArrayList<Move> moves,int x,int y){
		// S
		if(valid(x,y-1) &&
				(!board.getTile(x,y-1).isOccupied() ||
						(board.getTile(x,y-1).isOccupied() && board.getTile(x,y-1).getPiece().getColor() != color)))
			moves.add(new Move(x,y,x,y-1));

	}
	private void checkSouthWest(Board board,ArrayList<Move> moves,int x,int y){

		// SW
		if(valid(x-1,y-1) &&
				(!board.getTile(x-1,y-1).isOccupied() ||
						(board.getTile(x-1,y-1).isOccupied() && board.getTile(x-1,y-1).getPiece().getColor() != color)))
			moves.add(new Move(x,y,x-1,y-1));

	}
	private void checkWest(Board board,ArrayList<Move> moves,int x,int y){
		// W
		if(valid(x-1,y) &&
				(!board.getTile(x-1,y).isOccupied() ||
						(board.getTile(x-1,y).isOccupied() && board.getTile(x-1,y).getPiece().getColor() != color)))
			moves.add(new Move(x,y,x-1,y));

	}
	private void checkNorthWest(Board board,ArrayList<Move> moves,int x,int y){
// NW
		if(valid(x-1,y+1) &&
				(!board.getTile(x-1,y+1).isOccupied() ||
						(board.getTile(x-1,y+1).isOccupied() && board.getTile(x-1,y+1).getPiece().getColor() != color)))
			moves.add(new Move(x,y,x-1,y+1));

	}
	private void checkIfKingHasMoved(Board board,ArrayList<Move> moves,int x,int y){
		if(color == Piece.WHITE) {
			if(!hasMoved && x == Board.e && y == 1-1) {
				if(!board.getTile(Board.f, 1-1).isOccupied() &&
						!board.getTile(Board.g, 1-1).isOccupied() &&
						board.getTile(Board.h, 1-1).isOccupied() &&
						board.getTile(Board.h, 1-1).getPiece().toString().equals("R"))
					moves.add(new Move(x,y,x+2,y));


			}
			else
				hasMoved = true;
		}
		else { // color == Piece.BLACK
			if(!hasMoved && x == Board.e && y == 8-1) {

			}
			else
				hasMoved = true;
		}


		// TODO King cannot move into open fire

	}
	public ArrayList<Move> getMoves(Board board, int x, int y) {
		ArrayList<Move> moves = new ArrayList<Move>();
		
	checkNorth(board,moves,x,y);
		checkNorthEast(board,moves,x,y);

		checkEast(board,moves,x,y);
		checkSouthEast(board,moves,x,y);
		checkSouth(board,moves,x,y);
		checkSouthWest(board,moves,x,y);
		checkWest(board,moves,x,y);
		checkNorthWest(board,moves,x,y);
		// Castling
		checkIfKingHasMoved(board,moves,x,y);

		
		return moves;
	}
}
