package bingo.game;
/**
 * 
 * Holds information about the Bingo ticket field
 *
 */
public class Field {
	/**
	 * The Bingo field number
	 */
	private int number;
	
	/**
	 * The Bingo ticket field is matched with Lototron number
	 */
	boolean match;

	/**
	 * Returns field number
	 * @return field number
	 */
	public int getNumber(){
		return this.number;
	}
	
	/**
	 * Creates new Field
	 * @param number Field number from 1 to 75
	 */
	public Field(int number) {

		if (number < 1 || number > 75) {
			throw new NumberFormatException("Allowed 1-75, entered " + number);
		}

		this.number = number;

	}

	/**
	 * Formats field for printing
	 */
	public String toString() {
		if (this.match) {
			return "X" + this.number;
		}
		return this.number+ "";
	}

}
