/**
 * 
 */
package chess;

/**
 * @author Gunnar Atli
 *
 */
public class Move {
	private int startingPointX, startingPointY, endingPointX, endingPointY;
	private boolean castling = false;

	/**
	 * 
	 */
	public Move(int startingPointX, int startingPointY, int endingPointX, int endingPointY) {
		this.startingPointX = startingPointX;
		this.startingPointY = startingPointY;
		this.endingPointX = endingPointX;
		this.endingPointY = endingPointY;
	}
	
	public Move(int startingPointX, int startingPointY, int endingPointX, int endingPointY, boolean castling) {
		this.startingPointX = startingPointX;
		this.startingPointY = startingPointY;
		this.endingPointX = endingPointX;
		this.endingPointY = endingPointY;
		this.castling = castling;
	}

	public int getStartingPointX() {
		return startingPointX;
	}

	public void setStartingPointX(int startingPointX) {
		this.startingPointX = startingPointX;
	}

	public int getEndingPointX() {
		return endingPointX;
	}

	public void setEndingPointX(int endingPointX) {
		this.endingPointX = endingPointX;
	}

	public int getStartingPointY() {
		return startingPointY;
	}

	public void setStartingPointY(int startingPointY) {
		this.startingPointY = startingPointY;
	}

	public int getEndingPointY() {
		return endingPointY;
	}

	public void setEndingPointY(int endingPointY) {
		this.endingPointY = endingPointY;
	}
	
	public boolean isCastling() {
		return castling;
	}
	
	public String toString(){ // TODO change to a1 to b4 etc
		//return x1 + " " + y1 + " " + x2 + " " + y2;
		return (char)('A'+startingPointX) + "" + (startingPointY+1) + " " + (char)('A'+endingPointX) + "" + (endingPointY+1);
	}
	
	public boolean equals(Object o){
		Move op = (Move) o;
		
		if(op.getStartingPointX() == startingPointX && op.getStartingPointY() == startingPointY && op.getEndingPointX() == endingPointX && op.getEndingPointY() == endingPointY){
			return true;
		}
		else
			return false;
	}
}
