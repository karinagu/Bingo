package bingo.game;

public class Field {
	int number;
	boolean match;

	public Field(int number) {

		if (number < 1 || number > 75) {
			throw new NumberFormatException("Allowed 1-75");
		}

		this.number = number;

	}

	public char GetLetter() {
		int index=(int) Math.ceil((double)this.number/15);
		return "BINGO".charAt(index-1);
	}
	
	
}

