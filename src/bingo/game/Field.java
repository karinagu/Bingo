package bingo.game;

public class Field {
	private int number;
	boolean match;

	public int getNumber(){
		return this.number;
	}
	
	public Field(int number) {

		if (number < 1 || number > 75) {
			throw new NumberFormatException("Allowed 1-75, entered " + number);
		}

		this.number = number;

	}


	public String toString() {
		if (this.match) {
			return "X" + this.number;
		}
		return this.number+ "";
	}

}
