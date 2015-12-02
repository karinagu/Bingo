package bingo.game;

/**
 * 
 * The Bingo Game
 */
public class Game {

	public static void main(String[] args) {

		Ticket ticket = new Ticket();
		System.out.println(ticket);

		Lototron loto = new Lototron();

		int nextNumber = loto.getNextNumber();

		while (nextNumber > 0) {
			LototronResult result = loto.checkTicket(ticket);
			PrintNumber(nextNumber, result, ticket);

			if (result == LototronResult.WIN_FULL) {
				break;
			}

			nextNumber = loto.getNextNumber();
		}
	}

	static int counter = 0;

	/**
	 * Formating lototron number for showing in console
	 * 
	 * @param number
	 *            lototron number
	 * @param result
	 *            ticket check result
	 * @param ticket
	 *            ticket
	 */
	static void PrintNumber(int number, LototronResult result, Ticket ticket) {
		counter++;
		System.out.print(counter + ": " + Lototron.getLetter(number) + " " + number);

		if (result != LototronResult.NONE) {
			System.out.println(" !" + result);
			System.out.println(ticket);
		} else
			System.out.println();
	}
}
