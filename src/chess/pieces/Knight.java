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
public class Knight extends Piece {

	/**
	 * 
	 */
	public Knight(boolean color) {
		super(color);
		value = 3;
	}
	
	public Knight clone() {
		return new Knight(color);
	}

	public String toString() {
		if(color == Piece.WHITE)
			return "N";
		else
			return "n";
	}
	private void checkNorthNorthEast(Board board,ArrayList<Move> moves,int x,int y){
// NNE
		if(valid(x+1, y+2) &&
				(!board.getTile(x+1, y+2).isOccupied() ||
						(board.getTile(x+1, y+2).isOccupied() && board.getTile(x+1, y+2).getPiece().getColor() != color)))
			moves.add(new Move(x,y,x+1, y+2));

	}

	private void checkEastNorthEast(Board board,ArrayList<Move> moves,int x,int y){
// ENE
		if(valid(x+2, y+1) &&
				(!board.getTile(x+2, y+1).isOccupied() ||
						(board.getTile(x+2, y+1).isOccupied() && board.getTile(x+2, y+1).getPiece().getColor() != color)))
			moves.add(new Move(x,y,x+2, y+1));

	}
	private void checkEastSouthEast(Board board,ArrayList<Move> moves,int x,int y){
// ESE
		if(valid(x+2,y-1) &&
				(!board.getTile(x+2,y-1).isOccupied() ||
						(board.getTile(x+2,y-1).isOccupied() && board.getTile(x+2,y-1).getPiece().getColor() != color)))
			moves.add(new Move(x,y,x+2,y-1));

	}
	private void checkSouthSouthEast(Board board,ArrayList<Move> moves,int x,int y){

		// SSE
		if(valid(x+1,y-2) &&
				(!board.getTile(x+1,y-2).isOccupied() ||
						(board.getTile(x+1,y-2).isOccupied() && board.getTile(x+1,y-2).getPiece().getColor() != color)))
			moves.add(new Move(x,y,x+1,y-2));

	}
	private void checkSouthSouthWest(Board board,ArrayList<Move> moves,int x,int y){

		// SSW
		if(valid(x-1,y-2) &&
				(!board.getTile(x-1,y-2).isOccupied() ||
						(board.getTile(x-1,y-2).isOccupied() && board.getTile(x-1,y-2).getPiece().getColor() != color)))
			moves.add(new Move(x,y,x-1,y-2));

	}
	private void checkNorthNorthWest(Board board,ArrayList<Move> moves,int x,int y){

		// NNW
		if(valid(x-1,y+2) &&
				(!board.getTile(x-1,y+2).isOccupied() ||
						(board.getTile(x-1,y+2).isOccupied() && board.getTile(x-1,y+2).getPiece().getColor() != color)))
			moves.add(new Move(x,y,x-1,y+2));

	}
	private void checkWestSouthWest(Board board,ArrayList<Move> moves,int x,int y){

		// WSW
		if(valid(x-2,y-1) &&
				(!board.getTile(x-2,y-1).isOccupied() ||
						(board.getTile(x-2,y-1).isOccupied() && board.getTile(x-2,y-1).getPiece().getColor() != color)))
			moves.add(new Move(x,y,x-2,y-1));


	}
	private void chechWestNorthWest(Board board,ArrayList<Move> moves,int x,int y){

		// WNW
		if(valid(x-2,y+1) &&
				(!board.getTile(x-2,y+1).isOccupied() ||
						(board.getTile(x-2,y+1).isOccupied() && board.getTile(x-2,y+1).getPiece().getColor() != color)))
			moves.add(new Move(x,y,x-2,y+1));


	}
	public ArrayList<Move> getMoves(Board board, int x, int y) {
		ArrayList<Move> moves = new ArrayList<Move>();

		checkNorthNorthEast( board, moves, x, y);
		 checkEastNorthEast( board,moves, x, y);
		checkEastSouthEast( board, moves, x, y);
	 checkSouthSouthEast( board, moves, x, y);
		checkSouthSouthWest( board, moves, x, y);
		checkNorthNorthWest( board, moves, x, y);
		checkWestSouthWest( board, moves, x, y);
	chechWestNorthWest( board,moves, x, y);

		return moves;
	}
}
